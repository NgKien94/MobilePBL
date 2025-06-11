package com.example.pbl5.model

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Warning{
    var info: String = ""
    var timestamp: String = ""
    var type:String = ""

    constructor() // cần cho firebase
    constructor(info:String,timestamp: String, type:String){
        this.info = info
        this.timestamp = timestamp
        this.type = type
    }
    fun getTimestampAsDate(): Date? {
        return try {
            val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
            sdf.parse(this.timestamp)
        } catch (e: Exception) {
            null
        }
    }

    fun getTypeCategory(): String {
        return type.split("_").firstOrNull() ?: type;  // the same as getOrNull(index)
    }

}