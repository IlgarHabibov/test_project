package com.example.atlandroidexamples.practices.practice19

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import androidx.core.content.withStyledAttributes
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.LayoutMyCustomViewBinding
import com.google.android.material.card.MaterialCardView

class Banner @JvmOverloads constructor (
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
): MaterialCardView(context, attributeSet, defStyleAttr) {

    private val binding  = LayoutMyCustomViewBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    private var titleText = ""
    private var titleTextSize = 0
    private var titleTextColor = 0

    init {
        context.withStyledAttributes(attributeSet ,R.styleable.Banner){
            titleText = this.getString(R.styleable.Banner_titleText).orEmpty()
            titleTextSize = this.getDimensionPixelSize(R.styleable.Banner_titleSize, 0)
            titleTextColor = this.getColor(R.styleable.Banner_titleTextColor, Color.WHITE)
        }

        initViews()
    }


    private fun initViews(){
        binding.title.text = titleText
        binding.title.setTextColor(titleTextColor)
        binding.title.setTextSize(TypedValue.COMPLEX_UNIT_PX, titleTextSize.toFloat())
    }
}