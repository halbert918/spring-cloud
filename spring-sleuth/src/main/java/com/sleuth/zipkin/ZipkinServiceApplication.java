package com.sleuth.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import zipkin.server.EnableZipkinServer;

/**
 * Created by admin on 2016/12/7.
 * zipKin服务
 */
@ComponentScan("com.*")
@EnableAutoConfiguration
@PropertySource(value = {"classpath:application.yml"})
@EnableConfigurationProperties
@EnableZipkinServer
public class ZipkinServiceApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ZipkinServiceApplication.class, args);
    }

}
