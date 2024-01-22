package com.example.atlandroidexamples.lessons.lesson39

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.withStyledAttributes
import com.example.atlandroidexamples.R

class IndicatorView @JvmOverloads constructor(
    context: Context,
    private val attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attributeSet, defStyleAttr) {


    private val childList = mutableListOf<Boolean>()
    private var activeDrawable: Drawable? = null
    private var deActiveDrawable: Drawable? = null
    private var currentStep = 0
    private var childrenCount = 0
    private var itemSize: Int = 40
    private var itemPadding: Int = 40




    init {

        context.withStyledAttributes(attributeSet, R.styleable.IndicatorView){
            activeDrawable = this.getDrawable(R.styleable.IndicatorView_activeDrawable)
            deActiveDrawable = this.getDrawable(R.styleable.IndicatorView_deActiveDrawable)
            currentStep = this.getInt(R.styleable.IndicatorView_currentStep, 0)
            childrenCount = this.getInt(R.styleable.IndicatorView_childCount, 0)
            itemSize = this.getDimensionPixelSize(R.styleable.IndicatorView_itemSize, 40)
            itemPadding = this.getDimensionPixelSize(R.styleable.IndicatorView_itemPadding, 40)
        }

        initView()
    }

    private fun initView(){
        orientation = HORIZONTAL
        gravity = Gravity.CENTER

        initChild()
    }


    private fun initChild(){
        removeAllViews()
        initChildrenCount()
        initCurrentStep()
        childList.forEachIndexed{index, isActive ->
            val view = ImageView(context)
            val layoutParams = LayoutParams(itemSize, itemSize)
            if (isActive){
                view.background = activeDrawable
            }else{
                view.background = deActiveDrawable
            }
            if (index > 0){
                layoutParams.setMargins(itemPadding, 0, 0 ,0 )
            }
            view.layoutParams = layoutParams
            addView(view)
        }
    }


    fun setChildrenCount(count: Int) {
        childrenCount = count
        initChild()
    }

    private fun initChildrenCount(){
        childList.clear()
        for (i in 0 until childrenCount) {
            childList.add(false)
        }
    }



    fun setCurrentStep(step: Int){
        currentStep = step
        initChild()
    }


    private fun initCurrentStep(){
        childList.forEachIndexed{index, isActive ->
            if (index < currentStep){
                childList[index] = true
            }
        }
    }



    fun setActiveDrawable(drawable: Drawable?){
        activeDrawable = drawable
    }

    fun setDeActiveDrawable(drawable: Drawable?){
        deActiveDrawable = drawable
    }

}