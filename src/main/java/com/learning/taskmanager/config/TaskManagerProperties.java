package com.learning.taskmanager.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "taskmanager")
public record TaskManagerProperties(
        String appName,
        int maxtasks,
        boolean notificationsEnabled
) {
}
