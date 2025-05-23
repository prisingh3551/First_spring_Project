package com.priya.First_spring_Project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController   //anotation that is going to make a class capable to telling springboot what kind of mappings are present inside this springboot application
public class myController {
    // this is called an api

    // when a get request is made on the url("/add_two_numbers") then this is run
    @GetMapping("/add_two_numbers")
    public int addTwoNumbers(
        @RequestParam int a, 
        @RequestParam int b) {
        return a + b;
    }

    @GetMapping("/mul_two_numbers")
    public int mulTwoNumbers(
        @RequestParam int a, 
        @RequestParam int b) {
        return a * b;
    }
}
