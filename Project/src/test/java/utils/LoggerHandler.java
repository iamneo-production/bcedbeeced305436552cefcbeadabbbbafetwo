package utils;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerHandler {

    private static final Logger logger = Logger.getLogger(LoggerHandler.class);

    public static void main(String[] args) {
        LoggerHandler.initLog4j(); // Initialize Log4j before any logging
          logger.info("we are in");
    }

    public static void initLog4j() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    String timestamp = sdf.format(new Date());
    System.setProperty("log.timestamp", timestamp);
    
    // Initialize Log4j
    PropertyConfigurator.configure("src/main/resources/log4j.properties");
}

}