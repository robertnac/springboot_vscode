package de.ronasoft.springboot.vscode.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a simple controller class that returns a text message with the current date and time. 
 */
@RestController
public class TextController {

    @GetMapping("/text")
    public String getText() {
        return "Hello, the current date and time is: " + LocalDateTime.now();
    }
}