import me.mixo.library.BrowserDB
import me.mixo.library.HistoryData
import java.util.Date

fun main(args: Array<String>) {
    val browserDB = BrowserDB("jdbc:sqlite:C:\\Users\\moix\\Desktop\\browser2.db")
    browserDB.updateHistory(    HistoryData(
        45, "Google",
        Date().time,Date().time,
        "http://www.google.com"
    ))
}