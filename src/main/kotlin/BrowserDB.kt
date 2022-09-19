package me.mixo.library

import org.ktorm.database.Database
import org.ktorm.dsl.forEach
import org.ktorm.dsl.from
import org.ktorm.dsl.map
import org.ktorm.dsl.select
import org.ktorm.logging.ConsoleLogger
import org.ktorm.logging.LogLevel
import org.ktorm.logging.Slf4jLoggerAdapter


/**
 * MIUI浏览器数据库主类
 * @param url JDBC url eg: jdbc:sqlite:./test.db
 * @exception Throwable
 */
class BrowserDB(url:String) {
    private val database:Database
    init{
        try {
            database = Database.connect(
                url = url,
                driver = "org.sqlite.JDBC",
                logger =  ConsoleLogger(threshold = LogLevel.INFO)
            )
        }catch (e: Throwable){
            throw e
        }
    }
    fun getAllHistory():List<HistoryData>{
        try {
            val query = database.from(HistoryTable).select()
            val list = mutableListOf<HistoryData>()
            query.forEach {
                list.add(HistoryData(
                    id = it[HistoryTable.id] as Int, title =
                    it[HistoryTable.title].toString(),
                    created = it[HistoryTable.created] as Int, last_date = it[HistoryTable.last_date] as Int,
                    visits = it[HistoryTable.visits] as Int,
                    url = it[HistoryTable.url].toString(),
                    user_entered = it[HistoryTable.user_entered] as Int,
                    default_color = it[HistoryTable.default_color] as Int
                ))
            }
            return list
        }catch (e:Throwable){
            throw e
        }
    }
}

