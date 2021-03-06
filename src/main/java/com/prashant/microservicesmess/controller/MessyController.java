package com.prashant.microservicesmess.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessyController {

    @Autowired
    private Environment env;

    @GetMapping(value = "/greeting")
    public String greetingController() {
        return "HI";
    }

    @GetMapping(value = "/envdetails")
    public String envDetails() {
        return env.toString();
    }

}
