package com.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2016/12/7.
 */
@RestController
@RequestMapping("/spring/boot")
public class SampleController {

    @Value("${spring.name}")
    private String name;

    @Autowired
    private YmlConfig ymlConfig;

    @RequestMapping("")
    public String home() {
        return "Hello World, " + name;
    }
}
