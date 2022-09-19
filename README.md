```kotlin
import me.mixo.library.BrowserDB

val browserDB = BrowserDB("jdbc:sqlite:browser2.db")
browserDB.getAllHistory().forEach {
    println(it)
}
```