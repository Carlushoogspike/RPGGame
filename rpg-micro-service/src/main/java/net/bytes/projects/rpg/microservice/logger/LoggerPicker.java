package net.bytes.projects.rpg.microservice.logger;

import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class LoggerPicker {

    private static Map<LoggerLevel, String> messagesMap;

    public LoggerPicker() {
        messagesMap = new HashMap<>();
    }

    public static void pick(LoggerLevel loggerLevel, String message) {
        throwMessage(loggerLevel, message);
    }

    //http:
    private static void throwMessage(LoggerLevel loggerLevel, String message) {
        LoggerPrinter.printLog(loggerLevel, message);
        messagesMap.put(loggerLevel, message);
    }

    @Scheduled(fixedDelay = "30m")
    public void cleanLog() {
        //Send to panel 'RPGHopper' messages
        LoggerPrinter.printLog(LoggerLevel.LOW, "Cleaning up");
    }
}
