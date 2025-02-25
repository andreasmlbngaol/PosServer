package com.dabelyu.db

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.TransactionManager
import java.sql.Connection

object DatabaseFactory {
//    fun init(environment: ApplicationEnvironment) {
//        val config = environment.config.config("ktor.database")
//            jdbcUrl = config.propertyOrNull("url")?.getString()
//            driverClassName = config.propertyOrNull("driver")?.getString()
//            username = config.propertyOrNull("user")?.getString()
//            password = config.propertyOrNull("password")?.getString()

    fun init() {
        val hikariConfig = HikariConfig().apply {
            jdbcUrl = "jdbc:postgresql://localhost:5432/pos_db"
            driverClassName = "org.postgresql.Driver"
            username = "postgres"
            password = "password"
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
