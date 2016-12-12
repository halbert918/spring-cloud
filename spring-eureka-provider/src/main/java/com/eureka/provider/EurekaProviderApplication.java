package com.eureka.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by admin on 2016/12/7.
 */
@ComponentScan("com.*")
@EnableAutoConfiguration
@EnableEurekaClient
@PropertySource(value = {"classpath:application.yml"})
@EnableConfigurationProperties
public class EurekaProviderApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EurekaProviderApplication.class, args);
    }

}
