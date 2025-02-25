package com.dabelyu.repository

import com.dabelyu.models.StockTable
import com.dabelyu.models.UserTable
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

@Serializable
data class Stock(
    val id: Int,
    val code: String,
    val name: String,
    val price: Float,
    val stock: Int
)

@Serializable
data class User(
    val id: Int,
    val uid: String,
    val pin: String
)

object PosRepository {
    fun getAllItems() = transaction {
        StockTable
            .selectAll()
            .map {
                Stock(
                    id = it[StockTable.id],
                    code = it[StockTable.code],
                    name = it[StockTable.name],
                    price = it[StockTable.price],
                    stock = it[StockTable.stock]
                )
            }
        }

    fun getItemById(id: Int) = transaction {
        StockTable
            .select { StockTable.id eq id }
            .map {
                Stock(
                    id = it[StockTable.id],
                    code = it[StockTable.code],
                    name = it[StockTable.name],
                    price = it[StockTable.price],
                    stock = it[StockTable.stock]
                )
            }
            .singleOrNull()
    }

    fun getItemByCode(code: String) = transaction {
        StockTable
            .select { StockTable.code eq code }
            .map {
                Stock(
                    id = it[StockTable.id],
                    code = it[StockTable.code],
                    name = it[StockTable.name],
                    price = it[StockTable.price],
                    stock = it[StockTable.stock]
                )
            }
            .singleOrNull()
    }

    fun getUser(uid: String) = transaction {
        UserTable
            .select { UserTable.uid eq uid }
            .map {
                User(
                    id = it[UserTable.id],
                    uid = it[UserTable.uid],
                    pin = it[UserTable.pin]
                )
            }
            .singleOrNull()
    }

    fun getAllUsers() = transaction {
        UserTable
            .selectAll()
            .map {
                User(
                    id = it[UserTable.id],
                    uid = it[UserTable.uid],
                    pin = it[UserTable.pin]
                )
            }
    }

}
