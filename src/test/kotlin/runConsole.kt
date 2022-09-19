import me.mixo.library.BrowserDB

fun main(args: Array<String>) {
    val browserDB = BrowserDB("jdbc:sqlite:browser2.db")
    browserDB.getAllHistory().forEach {
        println(it)
    }
}