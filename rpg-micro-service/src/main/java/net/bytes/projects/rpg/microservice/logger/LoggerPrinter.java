package net.bytes.projects.rpg.microservice.logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LogPrinter handles the printing of log messages to the console based on log levels.
 * It supports log level filtering and thread safety.
 */
public class LoggerPrinter {

    private static final Lock lock = new ReentrantLock();
    private static LoggerLevel currentLogLevel = LoggerLevel.LOW;

    /**
     * Sets the log level threshold. Only logs at or above this level will be printed.
     *
     * @param loggerLevel the new log level threshold.
     */
    public static void setLogLevel(LoggerLevel loggerLevel) {
        currentLogLevel = loggerLevel;
    }

    /**
     * Prints a log message to the console with the appropriate log level and timestamp.
     * The log message is formatted according to the log level.
     *
     * @param loggerLevel the level of the log message (e.g., LOW, HIGH, etc.).
     * @param message     the log message to print.
     */
    public static void printLog(LoggerLevel loggerLevel, String message) {
        if (loggerLevel.getPriority() >= currentLogLevel.getPriority()) {
            lock.lock();
            try {
                String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

                String logMessage = String.format("[%s] [%s] %s: %s",
                        timestamp, Thread.currentThread().getName(), loggerLevel.name(), message);

                System.out.println(logMessage);
            } finally {
                lock.unlock();
            }
        }
    }

}
