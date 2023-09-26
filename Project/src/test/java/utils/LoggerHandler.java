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
        System.setProperty("log4j.configurationFile", "src/main/resource/log4j.xml");

        // Optional: Specify the log file directory
        String logDirectory = "/logs/"; // Specify your log directory name
        System.setProperty("logDirectory", logDirectory);

        // Create the log directory if it doesn't exist
        createLogDirectory(logDirectory);
    }

    private static void createLogDirectory(String logDirectory) {
        Path logPath = Paths.get(logDirectory);

        if (Files.notExists(logPath)) {
            try {
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
