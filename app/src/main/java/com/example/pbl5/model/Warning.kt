package com.example.pbl5.model

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

    fun getTypeCategory(): String {
        return type.split("_").firstOrNull() ?: type;  // the same as getOrNull(index)
    }

}