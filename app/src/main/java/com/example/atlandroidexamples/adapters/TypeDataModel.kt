package com.example.atlandroidexamples.adapters

sealed class TypeDataModel{
    data class Text(val text: String): TypeDataModel()
    data class Image(val id: Int): TypeDataModel()
    data class Button(val buttonText: String): TypeDataModel()
}
