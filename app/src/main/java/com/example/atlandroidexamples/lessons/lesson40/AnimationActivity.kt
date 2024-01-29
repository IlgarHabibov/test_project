package com.example.atlandroidexamples.lessons.lesson40

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.ChangeBounds
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.ActivityAnimationBinding
import com.example.atlandroidexamples.databinding.ActivityCustomViewBinding

class AnimationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimationBinding

    private var isExpanded = false
    private var isVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.start.setOnClickListener {
            startAutoTransitionAnimationFromCode()
        }


        binding.parentComponent.setOnClickListener {
            expandDesc()
            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun expandDesc() {

        isVisible = !isVisible
        val autoTransition = AutoTransition()
        autoTransition.duration = 500
        TransitionManager.beginDelayedTransition(binding.parentComponent, autoTransition)
        binding.desc.visibility =
            if (isVisible)
                View.VISIBLE
            else
                View.GONE

    }






    private fun startAnimationFromXML() {
        val animation = AnimationUtils.loadAnimation(
            this,
            R.anim.anim_alpha
        )

        binding.rectangle.startAnimation(animation)

//        AnimationUtils.loadAnimation(
//            this,
//            R.anim.anim_alpha
//        ).also { animation ->
//            binding.rectangle.startAnimation(animation)
//        }
    }

    private fun startAlphaAnimationFromCode() {

        val alphaAnimation = AlphaAnimation(1.0f, 0f)
        alphaAnimation.duration = 20000
        alphaAnimation.repeatMode = Animation.REVERSE
        alphaAnimation.repeatCount = Animation.INFINITE
        binding.rectangle.startAnimation(alphaAnimation)

    }

    private fun startScaleAnimationFromCode() {

        val scaleAnimation = ScaleAnimation(
            1.0f,
            1.5f,
            1.0f,
            2.0f
        )
        scaleAnimation.duration = 2000
        scaleAnimation.repeatMode = Animation.REVERSE
        scaleAnimation.repeatCount = Animation.INFINITE
        binding.rectangle.startAnimation(scaleAnimation)

    }

    private fun startRotateAnimationFromCode() {

        val rotateAnimation = RotateAnimation(
            0f,
            260f,
            Animation.RELATIVE_TO_PARENT,
            0.5f,
            Animation.RELATIVE_TO_PARENT,
            0.5f
        )
        rotateAnimation.duration = 2000
        rotateAnimation.repeatMode = Animation.REVERSE
        rotateAnimation.repeatCount = Animation.INFINITE
//        rotateAnimation.setAnimationListener(object : Animation.AnimationListener{
//            override fun onAnimationStart(p0: Animation?) {
//
//            }
//
//            override fun onAnimationEnd(p0: Animation?) {
//
//            }
//
//            override fun onAnimationRepeat(p0: Animation?) {
//                binding.rectangle.startAnimation(rotateAnimation)
//            }

//        })
        binding.rectangle.startAnimation(rotateAnimation)

    }

    private fun startTranslateAnimationFromCode() {

        val translateAnimation = TranslateAnimation(
            Animation.RELATIVE_TO_SELF,
            0f,
            Animation.RELATIVE_TO_SELF,
            1.0f,
            Animation.RELATIVE_TO_SELF,
            0f,
            Animation.RELATIVE_TO_SELF,
            0f
        )
        translateAnimation.duration = 2000
        translateAnimation.repeatMode = Animation.REVERSE
        translateAnimation.repeatCount = Animation.INFINITE
        binding.rectangle.startAnimation(translateAnimation)

    }

    private fun startColorAnimationFromCode() {

        val colorAnimator = ObjectAnimator.ofInt(
            binding.rectangle,
            "backgroundColor",
            ContextCompat.getColor(this, R.color.blue),
            ContextCompat.getColor(this, R.color.red),
            ContextCompat.getColor(this, R.color.green),
            ContextCompat.getColor(this, R.color.orange),
            ContextCompat.getColor(this, R.color.black),
        )

        colorAnimator.setEvaluator(ArgbEvaluator())
        colorAnimator.duration = 6000
        colorAnimator.repeatMode = ObjectAnimator.REVERSE
        colorAnimator.repeatCount = ObjectAnimator.INFINITE

        colorAnimator.start()

    }


    private fun startAlphaAnimationWithObjectFromCode(){
        val alphaAnimator = ObjectAnimator.ofFloat(
            binding.rectangle,
            "alpha",
            1.0f,
            0f
        )

        alphaAnimator.duration = 2000
//        alphaAnimator.repeatMode = ObjectAnimator.REVERSE
//        alphaAnimator.repeatCount = ObjectAnimator.INFINITE

        alphaAnimator.start()
    }

    private fun startWidthAnimationFromCode() {

        with(binding.rectangle) {
            val initialWidth = width
            val targetWidth = resources.getDimensionPixelSize(R.dimen.dimen_200dp)
            val widthAnimator = ValueAnimator.ofInt(initialWidth, targetWidth)
            widthAnimator.addUpdateListener { animator ->
                val params = layoutParams as ConstraintLayout.LayoutParams
                params.width = animator.animatedValue as Int
                layoutParams = params
            }
            widthAnimator.duration = 2000
//            widthAnimator.repeatMode = ValueAnimator.REVERSE
//            widthAnimator.repeatCount = ValueAnimator.INFINITE
            widthAnimator.start()
        }

    }

    private fun startChangeBoundsAnimationFromCode() {
        isExpanded = !isExpanded
        val changeBounds = ChangeBounds()
        changeBounds.duration = 1000
        TransitionManager.beginDelayedTransition(binding.root, changeBounds)
        val params = binding.rectangle.layoutParams
        params.height = if (isExpanded) 400 else 200
        binding.rectangle.layoutParams = params
    }

    private fun startChangeBoundsAnimationFromXML() {
        isExpanded = !isExpanded
        val transition = TransitionInflater
            .from(this)
            .inflateTransition(R.transition.change_bounds)
        TransitionManager.beginDelayedTransition(binding.root, transition)
        val params = binding.rectangle.layoutParams
        params.height = if (isExpanded) 400 else 200
        binding.rectangle.layoutParams = params
    }

    private fun startAutoTransitionAnimationFromCode() {
        isVisible = !isVisible
        val autoTransition = AutoTransition()
        autoTransition.duration = 1000
        TransitionManager.beginDelayedTransition(binding.root, autoTransition)
        binding.rectangle.visibility =
            if (isVisible)
                View.VISIBLE
            else
                View.GONE
    }

    private fun startAutoTransitionAnimationFromXML() {
        isVisible = !isVisible
        val transition = TransitionInflater
            .from(this)
            .inflateTransition(R.transition.auto_transition)
        TransitionManager.beginDelayedTransition(binding.root, transition)
        binding.rectangle.visibility =
            if (isVisible)
                View.VISIBLE
            else
                View.INVISIBLE
    }
}