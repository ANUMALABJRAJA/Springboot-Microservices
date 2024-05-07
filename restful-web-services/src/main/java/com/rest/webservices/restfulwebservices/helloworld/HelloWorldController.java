package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    MessageSource ms;
    public HelloWorldController(MessageSource ms){
        this.ms = ms;
    }

    @GetMapping("/hello-world")
    public String helloword(){
        return "Hello World";
    }


    @GetMapping("/hello-world-bean")
    public HelloWorldBean hellowordbean(){
        return new HelloWorldBean("Hello World From bean");
    }

    @GetMapping("/greeting-i18n")
    public String greet(){
        Locale locale = LocaleContextHolder.getLocale();
        return ms.getMessage("good.morning.message",null,"Default Message",locale);
    }
}
