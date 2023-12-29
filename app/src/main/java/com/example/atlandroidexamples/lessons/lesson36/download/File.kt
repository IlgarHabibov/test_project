package com.example.atlandroidexamples.lessons.lesson36.download

data class File(
    val id:String,
    val name:String,
    val type:String,
    val url:String,
    var downloadedUri:String?=null,
    var isDownloading:Boolean = false,
)
