package com.microservices1.limitsservice.controller;

import com.microservices1.limitsservice.bean.Limits;

import com.microservices1.limitsservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
    @Autowired
    private Configuration configuration;
    @GetMapping("/limits")
    public Limits retrieveLimits(){
        return new Limits(configuration.getMinimun(),configuration.getMaximun());
    }
}
