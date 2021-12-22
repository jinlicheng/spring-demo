package personal.jlc.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author kelvin
 */
@Configuration
@EnableConfigurationProperties(DemoProperties.class)
public class DemoConfig {
}
