package com.eureka.customer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/12/7.
 */
@RestController
@RequestMapping("/spring/customer")
public class CustomerController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @return
     */
    @RequestMapping("/rest")
    public Object restByEureka() {
        Object obj = restTemplate.getForObject("http://spring-eureka-provider/spring/service", String.class);
        return obj;
    }

    /**
     * 执行失败或者发生异常阻断降级执行对应的fallback
     * @return
     */
    @RequestMapping("/rest/hystrix")
    @HystrixCommand(fallbackMethod = "doFallback")
    public Object restByHystrix(){
        Object obj = restTemplate.getForObject("http://spring-eureka-provider/spring/service", String.class);
        throw new RuntimeException("ex ");
//        return obj;
    }

    /**
     * 调用超时时调用fallback阻断降级
     * @return
     */
    @RequestMapping("/rest/hystrix/time/out")
    @HystrixCommand(fallbackMethod = "doFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public Object restByHystrixTimeOut(){
        Object obj = restTemplate.getForObject("http://spring-eureka-provider/spring/service", String.class);
        return obj;
    }

    /**
     * 熔断、降级是调用
     * @return
     */
    private Object doFallback(){
        return "Test Hystrix";
    }

    /**
     * 获取注册中心的相关服务信息
     * @return
     */
    @RequestMapping("/discovery")
    public Object discovery() {
        Map<String, Object> map = new HashMap<String, Object>();
        //查询所有注册的应用服务信息
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(service);
            map.put(service, serviceInstances);
        }
        return map;
    }

}
