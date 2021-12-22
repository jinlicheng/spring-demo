package personal.jlc.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import personal.jlc.model.AppQO;
import personal.jlc.model.IAppSubModule;
import personal.jlc.service.IAppService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kelvin
 */
@Component
@Slf4j
public class AppModule extends SimpleModule implements InitializingBean, ApplicationContextAware {

    private final Map<String, Class<? extends IAppSubModule>> subModules = new HashMap<>();
    @Autowired
    private ObjectMapper objectMapper;
    private ApplicationContext applicationContext;

    public AppModule() {
        addDeserializer(AppQO.class, new StdScalarDeserializer<AppQO>(String.class) {
            @Override
            public AppQO deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {

                JsonNode jsonNode = ctx.readTree(jsonParser);
                log.debug(jsonNode.toPrettyString());

                AppQO app = new AppQO();
                app.setName(jsonNode.get("name").asText());

                Map<String, IAppSubModule> subModuleMap = new HashMap<>(1 << 4);

                for (Map.Entry<String, Class<? extends IAppSubModule>> next : subModules.entrySet()) {
                    String name = next.getKey();
                    Class<? extends IAppSubModule> clazz = next.getValue();
                    JsonNode devops = jsonNode.get(name);
                    if (devops != null) {
                        IAppSubModule subModule = objectMapper.treeToValue(devops, clazz);
                        subModuleMap.put(name, subModule);
                    }
                }

                app.setSubModuleMap(subModuleMap);

                return app;
            }
        });
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void afterPropertiesSet() {
        Map<String, IAppService> appServiceMap = applicationContext.getBeansOfType(IAppService.class);
        appServiceMap.values().forEach(i -> subModules.put(i.getName(), i.getRealType()));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
