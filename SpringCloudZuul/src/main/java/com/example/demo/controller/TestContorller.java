package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by administrator on 2019/1/7.
 */
@RestController
public class TestContorller {

    @Value("${name}")
    private String name;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(){
        return "config的值是："+name;
    }
}
