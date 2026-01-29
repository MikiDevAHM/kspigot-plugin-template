package me.template.myplugin

import net.axay.kspigot.main.KSpigot
import me.template.myplugin.database.Database
import me.template.myplugin.cache.PlayerCache

class MyPlugin : KSpigot() {

    lateinit var database: Database
    lateinit var cache: PlayerCache

    override fun startup() {
        saveDefaultConfig()
        database = Database(this)
        cache = PlayerCache()
        logger.info("KSpigot template iniciado")
    }

    override fun shutdown() {
        database.shutdown()
    }
}
