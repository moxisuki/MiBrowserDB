import me.mixo.library.BrowserDB
import java.util.Date

fun main(args: Array<String>) {
    val browserDB = BrowserDB("jdbc:sqlite:C:\\Users\\moix\\Desktop\\browser2.db")
    browserDB.getHistoryInterval(1659283200000,Date().time).forEach {
        println(it)
    }
}