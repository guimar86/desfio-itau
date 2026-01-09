package com.desafio.itau;

import com.desafio.itau.config.StatsConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({StatsConfiguration.class})
public class ItauApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItauApplication.class, args);
    }

}
