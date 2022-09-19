package me.moix.library

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.long
import org.ktorm.schema.text

object HistoryTable : Table<Nothing>("history") {
    val id = int("_id").primaryKey()
    val title = text("title")
    val created = long("created")
    val last_date = long("date")
    val visits = int("visits")
    val url = text("url")
    val user_entered = int("user_entered")
    val default_color = int("default_color")
}

data class HistoryData(
    val id:Int,
    val title:String,
    val created:Long,
    val last_date:Long,
    val url :String,
    val visits:Int? = 0,
    val user_entered:Int? = 0,
    val default_color:Int? = -1
)