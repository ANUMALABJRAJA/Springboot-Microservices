package com.microserviceX.microserviceX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XController {
    @Autowired
    private PersonExtract px;
    @GetMapping("xmapping")
    public Person getX(){
        return new Person(px.getName(),px.getAge());
    }
}
