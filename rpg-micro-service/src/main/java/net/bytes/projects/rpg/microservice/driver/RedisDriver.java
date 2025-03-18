package net.bytes.projects.rpg.microservice.driver;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;

@Factory
public class RedisDriver {

    @Singleton
    @Bean
    RedisClient redisClient() {
        return RedisClient.create(RedisURI.create("redis://redis-rpg-microservice:6379"));
    }

    @Singleton
    @Bean
    StatefulRedisConnection<String, String> getConnection(RedisClient client) {
        return client.connect();
    }
}
