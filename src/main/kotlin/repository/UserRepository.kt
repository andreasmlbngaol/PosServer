package com.dabelyu.repository

import com.dabelyu.models.UserTable
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

@Serializable
data class User(val id: Int, val name: String, val email: String)

object UserRepository {
    fun getAllUsers(): List<User> = transaction {
        UserTable.selectAll().map {
            User(it[UserTable.id], it[UserTable.name], it[UserTable.email])
        }
    }

    fun addUser(name: String, email: String): User? = transaction {
        val insertedId = UserTable.insert {
            it[UserTable.name] = name
            it[UserTable.email] = email
        }[UserTable.id] // Ambil ID yang baru dimasukkan

        getUserById(insertedId)
    }

    fun getUserById(id: Int): User? = transaction {
        UserTable.select { UserTable.id eq id }
            .map { User(it[UserTable.id], it[UserTable.name], it[UserTable.email]) }
            .singleOrNull()
    }
}
