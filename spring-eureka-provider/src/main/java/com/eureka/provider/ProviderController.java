package com.eureka.provider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2016/12/7.
 */
@RestController
@RequestMapping("/spring/service")
public class ProviderController {

    @RequestMapping("")
    public Object discovery() {
        return "test";
    }
}
