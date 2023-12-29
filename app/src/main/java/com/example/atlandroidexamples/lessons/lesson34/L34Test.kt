package com.example.atlandroidexamples.lessons.lesson34

fun main() {


    var person = Person("Ilgar", 32)
    val result = person.also {
            it.age++
    }

    println("Step 2 -> $result")
    println("Step 3 -> ${person.age}")

    println("Step 4 -> $result")
    println("Step 5 -> ${person.age}")
}



data class Person(var name: String, var age: Int)
