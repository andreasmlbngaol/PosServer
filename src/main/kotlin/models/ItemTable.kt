package com.dabelyu.models

import org.jetbrains.exposed.sql.Table

object ItemTable : Table("items") {
    val code = integer("code").autoIncrement()
    val name = varchar("name", 50)
    val price = float("price")
    override val primaryKey = PrimaryKey(code)
}
