package com.learning.taskmanager.config;

import com.learning.taskmanager.model.EnviromentMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdMessageConfig {
    @Bean
    public EnviromentMessage enviromentMessage(){
        return new EnviromentMessage("task manager ruleaza in PROD");
    }
}
