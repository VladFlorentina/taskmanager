package com.learning.taskmanager.config;

import com.learning.taskmanager.model.Appinfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:company.properties")
@ImportResource("classpath:beans.xml")
public class AppConfig {
    @Bean
    public Appinfo appinfo(@Value("${taskmanager.app-name}") String appName){
        return new Appinfo(appName);
    }

    @Bean("factoryGreetingService")
    public GreetingFactoryBean greetingFactoryBean() {
        return new GreetingFactoryBean();
    }
}
