package com.example.atlandroidexamples.lesson16

object Human {

    private var name: String = ""

    fun setHumanName(newName: String){
        name = newName
    }

    fun getHumanName() = name

}


object Keys{
    const val NAME = "name"
}