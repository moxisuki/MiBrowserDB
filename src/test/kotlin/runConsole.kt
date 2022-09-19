import me.mixo.library.BrowserDB

fun main(args: Array<String>) {
    val browserDB = BrowserDB("jdbc:sqlite:C:\\Users\\moix\\Desktop\\browser2.db")
    browserDB.getAllHistory()
}