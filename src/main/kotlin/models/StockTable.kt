package com.dabelyu.models

import org.jetbrains.exposed.sql.Table

object StockTable : Table("stocks") {
    val id = integer("id").autoIncrement()
    val code = varchar("code", 32)
    val name = varchar("name", 50)
    val price = float("price")
    val stock = integer("stock")
    override val primaryKey = PrimaryKey(id)
}
