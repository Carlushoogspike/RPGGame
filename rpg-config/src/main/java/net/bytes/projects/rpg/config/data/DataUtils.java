package net.bytes.projects.rpg.config.data;

import java.nio.charset.StandardCharsets;

public class DataUtils {

    public static String toText(byte[] data) {
        if (data == null || data.length == 0) {
            log.info("Can't possible read data!");
            return null;
        }

        String jsonString = new String(data, StandardCharsets.UTF_8);
        if (jsonString.isEmpty()) {
            log.info("Can't possible convert data to JSON!");
            return null;
        }

        return jsonString;
    }

}
