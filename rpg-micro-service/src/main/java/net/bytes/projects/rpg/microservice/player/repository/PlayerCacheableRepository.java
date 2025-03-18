package net.bytes.projects.rpg.microservice.player.repository;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.micronaut.scheduling.annotation.Async;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.bytes.projects.rpg.microservice.data.filter.RepositoryFilter;
import net.bytes.projects.rpg.microservice.player.model.PlayerDTO;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Singleton
public class PlayerCacheableRepository {

    private final RedisAsyncCommands<String, String> asyncCommands;

    public PlayerCacheableRepository(StatefulRedisConnection<String, String> connection) {
        this.asyncCommands = connection.async();
    }

    private String directKey(UUID uuid) {
        return "user:" + uuid.toString();
    }

    @Async
    public CompletableFuture<PlayerDTO> findPlayerById(UUID uuid) {
        return asyncCommands.hgetall(directKey(uuid)).thenApply(resultMap -> {
                    if (resultMap == null) {
                        log.warn("No data found for uuid: {}", uuid);
                        return null;
                    }

                    return PlayerDTO.deserializeFromMap(resultMap);
                }).exceptionally(ex -> (PlayerDTO) RepositoryFilter.handleException(ex))
                .toCompletableFuture();
    }

}
