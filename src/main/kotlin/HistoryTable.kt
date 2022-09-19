package me.mixo.library

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.text

object HistoryTable : Table<Nothing>("history") {
    val id = int("_id").primaryKey()
    val title = text("title")
    val created = int("created")
    val last_date = int("date")
    val visits = int("visits")
    val url = text("url")
    val user_entered = int("user_entered")
    val default_color = int("default_color")
}

data class HistoryData(
    val id:Int,
    val title:String,
    val created:Int,
    val last_date:Int,
    val url :String,
    val visits:Int,
    val user_entered:Int,
    val default_color:Int
)