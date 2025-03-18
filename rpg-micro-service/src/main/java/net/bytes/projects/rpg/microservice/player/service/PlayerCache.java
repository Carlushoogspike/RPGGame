package net.bytes.projects.rpg.microservice.player.service;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Singleton;
import net.bytes.projects.rpg.microservice.player.model.PlayerDTO;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Singleton
public class PlayerCache {

    private final Cache<UUID, PlayerDTO> cache;

    public PlayerCache() {
        cache = Caffeine.newBuilder()
                .expireAfterAccess(25, TimeUnit.MINUTES)
                .build();
    }


    public PlayerDTO getPlayer(UUID uuid) {
        return cache.getIfPresent(uuid);
    }

    public void putPlayer(PlayerDTO player) {
        cache.put(player.getUniqueId(), player);
    }

    @PreDestroy
    public void destroy() {
        cache.cleanUp();
    }

}
