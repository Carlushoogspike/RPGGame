package net.bytes.projects.rpg.microservice.data.filter;

import com.mongodb.client.model.Filters;
import lombok.extern.slf4j.Slf4j;
import net.bytes.projects.rpg.core.exceptions.FieldParserException;
import net.bytes.projects.rpg.microservice.logger.LoggerLevel;
import net.bytes.projects.rpg.microservice.logger.LoggerPicker;
import net.bytes.projects.rpg.microservice.logger.LoggerPrinter;
import org.bson.conversions.Bson;

import java.util.UUID;

@Slf4j
public class RepositoryFilter {

    public static Bson createFilter(FetchFilters args, String value) {
        switch (args) {
            case PLAYER_NAME:
                return Filters.eq(args.getFieldName(), value);
            case PLAYER_UNIQUE_ID:
                try {
                    UUID uuid = UUID.fromString(value);
                    return Filters.eq(args.getFieldName(), uuid);
                } catch (IllegalArgumentException e) {
                    throw new FieldParserException(args.getFieldName());
                }
            default:
                return null;
        }
    }

    public static Object handleException(Throwable exception) {
        LoggerPicker.pick(LoggerLevel.HIGH,"Error while processing filter");
        return null;
    }
}
