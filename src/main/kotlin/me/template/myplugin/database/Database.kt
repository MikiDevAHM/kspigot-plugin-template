package me.template.myplugin.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.bukkit.plugin.java.JavaPlugin

class Database(plugin: JavaPlugin) {

    private val dataSource: HikariDataSource

    init {
        val cfg = plugin.config
        val hikari = HikariConfig().apply {
            jdbcUrl = "jdbc:mysql://${cfg.getString("database.host")}:${cfg.getInt("database.port")}/${cfg.getString("database.name")}"
            username = cfg.getString("database.user")
            password = cfg.getString("database.password")
            maximumPoolSize = 10
            poolName = "MyPlugin-Hikari"
        }
        dataSource = HikariDataSource(hikari)
    }

    fun getConnection() = dataSource.connection

    fun shutdown() {
        dataSource.close()
    }
}
