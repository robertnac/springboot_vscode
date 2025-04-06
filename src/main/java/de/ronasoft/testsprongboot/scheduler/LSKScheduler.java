package de.ronasoft.testsprongboot.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class LSKScheduler {

    // Create an SLF4J logger instance
    private static final Logger LOGGER = LoggerFactory.getLogger(LSKScheduler.class);

    // Inject the cron expression from application.yml
    @Value("${scheduler.cron}")
    private String cronExpression;

    // Inject the JdbcTemplate bean
    private final JdbcTemplate jdbcTemplate;

    public LSKScheduler(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Runs based on the cron expression
    @Scheduled(cron = "${scheduler.cron}")
    public void scheduledJob() {
        // Get the current time
        LocalDateTime now = LocalDateTime.now();

        // Format the time in a human-readable format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = now.format(formatter);

        // Log the formatted time
        LOGGER.info("Scheduled task executed at: {}", formattedTime);

        // Example usage of JdbcTemplate
        int rowCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM some_table", Integer.class);
        LOGGER.info("Row count in 'some_table': {}", rowCount);
    }
}