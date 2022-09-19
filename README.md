<!-- TOC -->

* [Get Started](#get-started)
* [History](#history)
    * [GetAllHistory](#getallhistory)
    * [GetHistoryInterval](#gethistoryinterval)
    * [InsertHistory](#inserthistory)
    * [DeleteHistory](#deletehistory)
    * [UpdateHistory](#updatehistory)

<!-- TOC -->

# Get Started

Database default path

```shell
/data/data/com.android.browser/databases/browser2.db
```

Initialization

```kotlin
val browserDB = BrowserDB("jdbc:sqlite:browser2.db")
```

# History

## GetAllHistory

```kotlin
browserDB
    .getAllHistory()
    .forEach { it ->
        println(it)
    }
```

## GetHistoryInterval

```kotlin
browserDB
    .getHistoryInterval(1659283200000, Date().time)
    .forEach { it ->
        println(it)
    }
```

## InsertHistory

```kotlin
browserDB.insertHistory(
    HistoryData(
        99, "Google",
        Date().time, Date().time,
        "http://www.google.com"
    )
)
```

## DeleteHistory

```kotlin
browserDB.deleteHistory(99)
```

## UpdateHistory

```kotlin
browserDB.updateHistory(
    HistoryData(
        99, "Google",
        Date().time, Date().time,
        "http://www.google.com"
    )
)
```