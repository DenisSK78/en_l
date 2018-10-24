package by.en.config;

import by.en.config.database.DataBaseConfig;
import by.en.config.web.WebConfig;
import com.sun.org.apache.xerces.internal.parsers.SecurityConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan(basePackages = {"by.en"})
@PropertySource(value = {
        "classpath:database.properties",
})
@Import({
        DataBaseConfig.class,
        WebConfig.class,
        SecurityConfiguration.class
})
public class AppConfig {
}

