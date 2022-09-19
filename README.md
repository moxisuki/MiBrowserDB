## Init
```kotlin
val browserDB = BrowserDB("jdbc:sqlite:browser2.db")
```

## GetAllHistory
```kotlin
browserDB
    .getAllHistory()
    .forEach { it->
        println(it)
}
```
## GetHistoryInterval
```kotlin
browserDB
    .getHistoryInterval(1659283200000,Date().time)
    .forEach { it->
        println(it)
}
```