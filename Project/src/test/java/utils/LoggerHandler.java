package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoggerHandler {

    private static final Logger logger = LogManager.getLogger(LoggerHandler.class);

    public static void main(String[] args) {
        initLog4j();
        logMessage("This is a sample log message.");
    }

    public static void initLog4j() {
        // Specify the location of the Log4j configuration file
        System.setProperty("log4j.configurationFile", "src/main/resource/Log4j.properties");

     System.out.println("ho123456");
        createLogDirectory();
    }

    private static void createLogDirectory() {
        // Get the log directory path from the Log4j configuration
        String logDirectory = System.getProperty("log4j.appender.RollingAppender.File");
        logDirectory = logDirectory.substring(0, logDirectory.lastIndexOf('/'));

        Path logPath = Paths.get(logDirectory);

        if (Files.notExists(logPath)) {
            try {
                 System.out.println("Checkin the directory");
                Files.createDirectories(logPath);
            } catch (IOException e) {
                logger.error("Failed to create the log directory: " + e.getMessage());
            }
        }
    }

    public static void logMessage(String message) {
        // Log the message using Log4j
        logger.info(message);
    }
}
