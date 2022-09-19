package me.moix.library

import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.ktorm.logging.ConsoleLogger
import org.ktorm.logging.LogLevel


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

    /**
     * 获取所有历史记录
     *
     * @return 符合条件的历史记录的集合
     */
    fun getAllHistory():List<HistoryData>{
        try {
            val query = database.from(HistoryTable).select()
            val list = mutableListOf<HistoryData>()
            query.forEach {
                list.add(HistoryData(
                    id = it[HistoryTable.id] as Int,
                    title = it[HistoryTable.title].toString(),
                    created = it[HistoryTable.created] as Long,
                    last_date = it[HistoryTable.last_date] as Long,
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

    /**
     * 获取指定区间内的数据
     *
     * @param start 开始时间 时间戳（毫秒）
     * @param end 结束时间 时间戳（毫秒）
     * @return 符合条件的历史记录的集合
     */
    fun getHistoryInterval(start: Long, end: Long):List<HistoryData>{
        try {
            val query = database.from(HistoryTable).select().where {
                HistoryTable.created greater start and (HistoryTable.created less end)
            }
            val list = mutableListOf<HistoryData>()
            query.forEach {
                list.add(HistoryData(
                    id = it[HistoryTable.id] as Int,
                    title = it[HistoryTable.title].toString(),
                    created = it[HistoryTable.created] as Long,
                    last_date = it[HistoryTable.last_date] as Long,
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

    /**
     * 插入一条历史记录
     * @param data HistoryData对象
     */
    fun insertHistory(data: HistoryData){
        try {
            database.insert(HistoryTable){
                set(it.id,data.id)
                set(it.title,data.title)
                set(it.created,data.created)
                set(it.last_date,data.last_date)
                set(it.visits,data.visits)
                set(it.url,data.url)
                set(it.user_entered,data.user_entered)
                set(it.default_color,data.default_color)
            }
        }catch (e:Throwable){
            throw e
        }
    }

    /**
     * 删除一条历史记录
     * @suppress 该方法的上一条方法不可为ID相同的插入操作
     * @param id
     */
    fun deleteHistory(id: Int){
        try {
            database.delete(HistoryTable){
                it.id eq id
            }
        }catch (e:Throwable){
            throw e
        }
    }

    /**
     * 更新一条历史记录
     * @param data
     */
    fun updateHistory(data: HistoryData){
        try {
            database.update(HistoryTable){
                set(it.title,data.title)
                set(it.created,data.created)
                set(it.last_date,data.last_date)
                set(it.visits,data.visits)
                set(it.url,data.url)
                set(it.user_entered,data.user_entered)
                set(it.default_color,data.default_color)
                where {
                    it.id eq data.id
                }
            }
        }catch (e:Throwable){
            throw e
        }
    }
}

