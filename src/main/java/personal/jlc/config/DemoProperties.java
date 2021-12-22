package personal.jlc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author kelvin
 */
@ConfigurationProperties(prefix = "bocloud.paas")
@Data
public class DemoProperties {

    private List<String> list1;
    private List<Object1> list2;
    private String[] list3;
    private Object1[] list4;

    @Data
    public static class Object1{
        private String name;
        private int age;
    }
}
