package com.dabelyu.models

import org.jetbrains.exposed.sql.Table

object UserTable: Table("users") {
    val id = integer("id").autoIncrement()
    val uid = varchar("uid", 12)
    val pin = char("pin", 60)
    override val primaryKey = PrimaryKey(id)
}