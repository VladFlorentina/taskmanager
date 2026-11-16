package com.learning.taskmanager.config;

import com.learning.taskmanager.service.XmlGreetingService;
import org.springframework.beans.factory.FactoryBean;

public class GreetingFactoryBean implements FactoryBean<XmlGreetingService> {

    @Override
    public XmlGreetingService getObject() {
        return new XmlGreetingService();
    }

    @Override
    public Class<?> getObjectType() {
        return XmlGreetingService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
