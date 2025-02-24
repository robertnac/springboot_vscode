package de.ronasoft.testsprongboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        return "Hello, " + name + "! The current time is " + formattedTime + ".";
    }

    @GetMapping("/hallo")
    public String sageHallo(@RequestParam(value = "name", defaultValue = "Welt") String name) {
        LocalDateTime aktuelleZeit = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatierteZeit = aktuelleZeit.format(formatter);
        return "Hallo, " + name + "! Die aktuelle Uhrzeit ist " + formatierteZeit + ".";
    }
}