package net.bytes.projects.rpg.microservice.data.filter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum FetchFilters {

    PLAYER_UNIQUE_ID("uniqueId"),
    PLAYER_NAME("displayName");

    private final String fieldName;

    public static FetchFilters fromField(String fieldName) {
        return Arrays.stream(values())
                .filter(f -> f.fieldName.equalsIgnoreCase(fieldName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid field: " + fieldName));
    }
}
