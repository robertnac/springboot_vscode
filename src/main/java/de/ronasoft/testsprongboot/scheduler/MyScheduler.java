package de.ronasoft.testsprongboot.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MyScheduler {

    // Runs once a day at 3 AM
    @Scheduled(cron = "0 0 3 * * ?")
    public void runTask() {
        // Get the current time
        LocalDateTime now = LocalDateTime.now();

        // Format the time in a human-readable format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = now.format(formatter);

        // Print the formatted time
        System.out.println("Scheduled task executed at: " + formattedTime);
    }
}