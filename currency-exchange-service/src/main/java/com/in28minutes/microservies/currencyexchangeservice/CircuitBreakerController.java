package com.in28minutes.microservies.currencyexchangeservice;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {
    @GetMapping("/sample-api")
    @Retry(name="sample-api",fallbackMethod = "defaultResponse")
    public String sampleApi(){
        return "Hello API";
    }
    public String defaultResponse(Exception e){
        return "Default Response";
    }

}
