package de.ronasoft.testsprongboot.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class LSKScheduler {

    // Create an SLF4J logger instance
    private static final Logger LOGGER = LoggerFactory.getLogger(LSKScheduler.class);

    // Runs once a day at 3 AM
    @Scheduled(cron = "0 0 3 * * ?")
    public void scheduledJob() {
        // Get the current time
        LocalDateTime now = LocalDateTime.now();

        // Format the time in a human-readable format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = now.format(formatter);

        // Log the formatted time
        LOGGER.info("Scheduled task executed at: {}", formattedTime);
    }
}