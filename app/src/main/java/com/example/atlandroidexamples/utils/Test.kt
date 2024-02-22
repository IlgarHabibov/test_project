package com.example.atlandroidexamples.utils


fun main() {
    calculate(1,2 , "-")
}

fun calculate(a: Int, b: Int, operation: String): Int{
    return when(operation){
        "+" -> a + b
        "-" -> a - b
        "*" -> a * b
        "/" -> a / b
        else -> 0
    }
}

fun plus(a:Int, b:Int): Int{
    return a + b
}