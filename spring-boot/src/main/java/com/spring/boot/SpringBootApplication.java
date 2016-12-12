package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by admin on 2016/12/7.
 */
@ComponentScan("com.spring.boot")
@EnableAutoConfiguration
@PropertySource(value = {"classpath:spring.properties", "classpath:application.yml"})
@EnableConfigurationProperties
public class SpringBootApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootApplication.class, args);
    }

    @Bean
    @ConfigurationProperties(prefix="spring")
    public YmlConfig build() {
        return new YmlConfig();
    }

}
