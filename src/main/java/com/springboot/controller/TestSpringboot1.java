package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSpringboot1 {

@RequestMapping(value = "test")
    public String testsp(){

    return  "欢迎来到springboot";
    }
}
