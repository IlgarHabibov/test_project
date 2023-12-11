package com.example.atlandroidexamples.utils.transformations

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import coil.size.Size
import coil.transform.Transformation


class WatermarkTransformation(private val watermarkText: String) : Transformation {


    override val cacheKey: String
        get() = "WatermarkTransformation"

    override suspend fun transform(input: Bitmap, size: Size): Bitmap {
        val canvas = Canvas(input)
        val paint = Paint().apply {
            color = Color.WHITE
            textSize = 50f
            isAntiAlias = true
        }

        // Draw the original image
        canvas.drawBitmap(input, 0f, 0f, null)

        // Draw the watermark text in the bottom-right corner
        val textBounds = Rect()
        paint.getTextBounds(watermarkText, 0, watermarkText.length, textBounds)
        val x = (input.width - textBounds.width()).toFloat()
        val y = (input.height - textBounds.height()).toFloat()
        canvas.drawText(watermarkText, x, y, paint)

        return input
    }


}
