package net.bytes.projects.rpg.microservice.logger;

import lombok.Getter;

/**
 * Enum to define different log levels for the logger system.
 * Each log level has a priority associated with it to determine the severity of the log.
 */
@Getter
public enum LoggerLevel {

    LOWEST(0), LOW(1), MEDIUM(2), HIGH(3), HIGHEST(4);

    /**
     *  Gets the priority of the log level.
     *  Higher priority means more severe logs.
     */
    private final int priority;

    LoggerLevel(int priority) {
        this.priority = priority;
    }

}
