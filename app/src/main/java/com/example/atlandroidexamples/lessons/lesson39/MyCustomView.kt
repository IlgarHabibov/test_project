package com.example.atlandroidexamples.lessons.lesson39

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyCustomView(context: Context): View(context) {

    private val paint = Paint()
    private val paint2 = Paint()


    constructor(context: Context, attributeSet: AttributeSet): this(context){

    }

    constructor(context: Context,
                attributeSet: AttributeSet,
                defStyleAttr: Int
    ): this(context, attributeSet){

    }

    init {
        paint.color = Color.BLUE
        paint2.color = Color.RED
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }

}