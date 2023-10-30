package com.example.atlandroidexamples.practices.practice8

sealed class PagerTaskModel{
    class Pending(val list: List<String>): PagerTaskModel()
    class Delivered(val list: List<String>): PagerTaskModel()
    class PhotoWithText( val imageId: Int, val text: String): PagerTaskModel()
    class PhotoWithButton( val imageId: Int, val buttonText: String): PagerTaskModel()
}
