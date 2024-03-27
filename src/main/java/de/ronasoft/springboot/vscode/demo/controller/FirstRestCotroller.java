package de.ronasoft.springboot.vscode.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This ist my first Rest Controller with Spring Boot
 * and it has a 'get' mepping 'hello'
 */

 @RestController
public class FirstRestCotroller {

    @GetMapping("/hello")
    public String hello() {
        return "hello world 2141"; 
    }      
}
