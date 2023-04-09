package org.example.mvcconfigs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Constants;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan(
    basePackages = {"org.example"},
    excludeFilters = {
        @ComponentScan.Filter(
            type = FilterType.ANNOTATION,
            value = {
                RestController.class,
                ControllerAdvice.class,
                Configuration.class
            }
        )
    }
)
@PropertySource("classpath:/app.properties")
@PropertySource(value = "classpath:/database.properties", ignoreResourceNotFound = true)
@PropertySource(value = "classpath:/src/main/resources-prod/persistence-jndi.properties", ignoreResourceNotFound = true)
public class AppConfig {

}