package com.desafio.itau.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "itau.app.stats")
public record StatsConfiguration(int minutes) {
}
