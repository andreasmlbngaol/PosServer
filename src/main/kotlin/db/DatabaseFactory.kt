package com.dabelyu.db

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.TransactionManager
import java.sql.Connection

object DatabaseFactory {
    fun init(environment: ApplicationEnvironment) {
        val config = environment.config.config("ktor.database")

        val hikariConfig = HikariConfig().apply {
            jdbcUrl = config.property("url").getString()
            driverClassName = config.property("driver").getString()
            username = config.property("user").getString()
            password = config.property("password").getString()
            maximumPoolSize = 5
            isAutoCommit = false
            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        }

        val dataSource = HikariDataSource(hikariConfig)
        Database.connect(dataSource)

        // Set default transaction isolation
        TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_REPEATABLE_READ
    }
}
