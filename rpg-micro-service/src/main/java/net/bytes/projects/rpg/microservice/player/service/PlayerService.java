package net.bytes.projects.rpg.microservice.player.service;

import io.micronaut.scheduling.annotation.Async;
import jakarta.inject.Singleton;

import net.bytes.projects.rpg.microservice.data.filter.RepositoryFilter;
import net.bytes.projects.rpg.microservice.player.model.PlayerDTO;
import net.bytes.projects.rpg.microservice.player.repository.PlayerCacheableRepository;
import net.bytes.projects.rpg.microservice.player.repository.PlayerPersistentRepository;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Singleton
public class PlayerService {

    private final PlayerCache cache;
    private final PlayerCacheableRepository redisRepository;
    private final PlayerPersistentRepository mongoRepository;

    public PlayerService(PlayerCache cache, PlayerCacheableRepository redisRepository, PlayerPersistentRepository mongoRepository) {
        this.cache = cache;
        this.redisRepository = redisRepository;
        this.mongoRepository = mongoRepository;
    }

    @Async
    public CompletableFuture<PlayerDTO> findPlayerById(UUID uuid) {
        PlayerDTO cachedDto = cache.getPlayer(uuid);
        if (cachedDto != null) {
            return CompletableFuture.completedFuture(cachedDto);
        }

        return redisRepository.findPlayerById(uuid).thenCompose(redisUser -> {
            if (redisUser != null) {
                cache.putPlayer(redisUser);
                return CompletableFuture.completedFuture(redisUser);
            }

            //Use mongo
            return CompletableFuture.completedFuture(null);
        }).exceptionally(ex -> (PlayerDTO) RepositoryFilter.handleException(ex));
    }
}
