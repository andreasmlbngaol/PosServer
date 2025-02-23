package com.dabelyu.repository

import com.dabelyu.models.ItemTable
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

@Serializable
data class Item(
    val code: Int,
    val name: String,
    val price: Float
)

object PosRepository {
    fun getAllItems(): List<Item> = transaction {
        ItemTable.selectAll().map { item ->
            Item(
                code = item[ItemTable.code],
                name = item[ItemTable.name],
                price = item[ItemTable.price]
            )
        }
    }

    fun getItemByCode(code: Int) = transaction {
        ItemTable.select { ItemTable.code eq code }
            .map { item ->
                Item(
                    code = item[ItemTable.code],
                    name = item[ItemTable.name],
                    price = item[ItemTable.price]
                )
            }
            .singleOrNull()
    }
}
