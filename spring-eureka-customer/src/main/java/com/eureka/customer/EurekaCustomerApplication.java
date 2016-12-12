package com.eureka.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

/**
 * Created by admin on 2016/12/7.
 */
@ComponentScan("com.*")
@EnableAutoConfiguration
@EnableEurekaClient      //配置服务注册与发现
@EnableCircuitBreaker    //配置服务熔断降级注解
@EnableHystrixDashboard  //配置服务降级Dashboard，可通过host:port//hystrix访问
@PropertySource(value = {"classpath:application.yml"})
@EnableConfigurationProperties
public class EurekaCustomerApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EurekaCustomerApplication.class, args);
    }

    /**
     * LoadBalanced:默认使用区域感知负载ZoneAwareLoadBalancer：默认为轮询
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public ILoadBalancer ribbonLoadBalancer() {
//        DefaultClientConfigImpl config = DefaultClientConfigImpl.getClientConfigWithDefaultValues();
//        config.setProperty(CommonClientConfigKey.NFLoadBalancerRuleClassName, "com.netflix.loadbalancer.WeightedResponseTimeRule");
//        config.setClientName("spring-eureka-provider");
//        return LoadBalancerBuilder.newBuilder()
//                .withClientConfig(config)
//                .withRule(new WeightedResponseTimeRule())
//                .buildLoadBalancerFromConfigWithReflection();
//    }

}
