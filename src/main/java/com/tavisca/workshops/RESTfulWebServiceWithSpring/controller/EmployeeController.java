package com.tavisca.workshops.RESTfulWebServiceWithSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/")
    public String homePage() {
        return "This is the home page";
    }
}
