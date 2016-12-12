# spring-cloud
spring-cloud

1、spring-eureka：服务注册与发现
    a) 添加依赖
      <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-starter-eureka-server</artifactId>
      </dependency>
    b) 通过注解@EnableEurekaServer开启服务
    c) 通过配置文件设置eureka服务
        server:
          port: 8088
        eureka:
          instance:
            hostname: 127.0.0.1
          client:
            registerWithEureka: false   #是否注册到服务（eureka本身是对外提供注册发现的应用服务，不需将自己注册）
            fetchRegistry: false         #是否拉取服务
            serviceUrl:
              defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
    d) 通过访问127.0.0.1:8088查看已注册的相关服务应用
2、spring-eureka-provider：服务提供者
    a) 引入依赖
    b) 配置服务注册发现地址
        eureka.client.serviceUrl.defaultZone: http://127.0.0.1:8088/eureka/
    c) 通过注解@EnableEurekaClient注册服务(服务注册与发现都是用该注解)
3、spring-eureka-customer：服务消费者
     a) 引入依赖
     b) 配置服务注册发现地址
        eureka.client.serviceUrl.defaultZone: http://127.0.0.1:8088/eureka/
     c) 通过注解@EnableEurekaClient发现服务(服务注册与发现都是用该注解)
     d) 服务阻断降级：通过@EnableCircuitBreaker开启服务降级
4、spring-sleuth：服务调用链追踪
    a) 引入依赖(以zipkin为例)
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        <dependency>
            <groupId>io.zipkin.java</groupId>
            <artifactId>zipkin-server</artifactId>
        </dependency>
        <dependency>
            <groupId>io.zipkin</groupId>
            <artifactId>zipkin-ui</artifactId>
        </dependency>
    b) 配置zipkin
        zipkin.storage.type: mem #mysql #存储位置  内存 ｜　mysql
    c) @EnableZipkinServer开启调用链监控
    d) 各应用服务配置：
        spring.zipkin.base-url: http://127.0.0.1:9411
        ps:调用restTemplate会自动注入追踪span信息上传到zipkin服务；
           可通过http://127.0.0.1:9411查看其调用链信息
