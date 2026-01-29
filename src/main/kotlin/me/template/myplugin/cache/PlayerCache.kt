package me.template.myplugin.cache

import com.github.benmanes.caffeine.cache.Caffeine
import java.util.UUID
import java.util.concurrent.TimeUnit

class PlayerCache {

    private val cache = Caffeine.newBuilder()
        .expireAfterAccess(10, TimeUnit.MINUTES)
        .maximumSize(10_000)
        .build<UUID, String>()

    fun put(uuid: UUID, value: String) {
        cache.put(uuid, value)
    }

    fun get(uuid: UUID): String? = cache.getIfPresent(uuid)
}
