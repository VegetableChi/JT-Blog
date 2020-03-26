package com.yd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StringController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/show")
    public String showMessage(@RequestParam String name){
        String forObject = restTemplate.getForObject("http://blog-producer/get?name=" + name, String.class);
        System.out.println(forObject);
        return forObject;
    }

}
