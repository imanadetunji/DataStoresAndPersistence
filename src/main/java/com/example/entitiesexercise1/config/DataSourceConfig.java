package com.example.entitiesexercise1.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties("com.example")
    public DataSource getDatasource(DataSourceProperties properties) {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.username("test");
        dataSourceBuilder.password(securePasswordService());
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/plant");
        return dataSourceBuilder.build();
    }

    private String securePasswordService() {
        return "test123";
    }
}
