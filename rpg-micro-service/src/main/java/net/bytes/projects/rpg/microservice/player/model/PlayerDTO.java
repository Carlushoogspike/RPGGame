package net.bytes.projects.rpg.microservice.player.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.bytes.projects.rpg.core.providers.PlayerProvider;
import net.bytes.projects.rpg.core.providers.attribute.Attribute;

import java.util.*;

@Data
@Serdeable
@MappedEntity
@AllArgsConstructor
public class PlayerDTO implements PlayerProvider {

    private UUID uniqueId;
    private String displayName;

    private int level;
    private double xp;

    private Set<Attribute> attributes;

    public PlayerDTO() {}

    @Override
    @JsonIgnore
    public Map<String, String> deserializeToMap() {
        Map<String, String> map = new HashMap<>();
        map.put("uniqueId", uniqueId.toString());
        map.put("displayName", displayName);
        map.put("level", String.valueOf(level));
        map.put("xp", String.valueOf(xp));
        return map;
    }

    @Override
    @JsonIgnore
    public PlayerDTO serializeFromMap(Map<String, String> map) {
        UUID uniqueId = UUID.fromString(map.get("uniqueId"));
        String displayName = map.get("displayName");
        int level = Integer.parseInt(map.get("level"));
        double xp = Double.parseDouble(map.get("xp"));

        return new PlayerDTO(uniqueId, displayName, level, xp, Collections.emptySet());
    }

    @JsonIgnore
    public static PlayerDTO deserializeFromMap(Map<String, String> map) {
        return new PlayerDTO().serializeFromMap(map);
    }
}
