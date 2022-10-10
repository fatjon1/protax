package com.protax.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class MainController {
    @GetMapping("/api")
    public String homePage(){
        return "Page under construction!!!";
    }
}
