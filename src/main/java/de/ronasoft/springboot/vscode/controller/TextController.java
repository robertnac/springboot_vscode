package de.ronasoft.springboot.vscode.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a simple controller class that returns a text message with the current date and time. 
 */
@RestController
public class TextController {

    private static final Logger logger = LoggerFactory.getLogger(TextController.class);


    @GetMapping("/text")
    public String getText() {
        logger.debug("Die Methode getText() wurde aufgerufen.");
        return "Hello, the current date and time is: " + LocalDateTime.now();
    }
}