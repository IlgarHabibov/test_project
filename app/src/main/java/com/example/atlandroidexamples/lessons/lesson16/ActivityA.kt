package com.example.atlandroidexamples.lessons.lesson16

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.activities.MainActivity
import com.example.atlandroidexamples.adapters.TypeAdapter
import com.example.atlandroidexamples.adapters.TypeDataModel
import com.example.atlandroidexamples.databinding.ActivityABinding
import com.example.atlandroidexamples.practices.practice8.PagerTaskModel
import com.example.atlandroidexamples.practices.practice8.SimpleListAdapter2
import com.example.atlandroidexamples.practices.practice8.TaskPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class ActivityA : AppCompatActivity() {
    private lateinit var binding: ActivityABinding
    private val pagerAdapter = TaskPagerAdapter(createPagerList())


    private val adapterNew = SimpleListAdapter2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityABinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.taskViewPager.adapter = pagerAdapter

        val mediator = TabLayoutMediator(binding.taskTableLayout, binding.taskViewPager){
            tab, position ->

            tab.text = createTabList()[position]
        }

        mediator.attach()


        binding.taskViewPager.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", "Ilgar")
            startActivity(intent)
        }

    }

    private fun createTabList() = listOf(
        "Page 1", "Page 2", "Pager 3"
    )

    private fun createPagerList() = listOf<PagerTaskModel>(
        PagerTaskModel.Delivered(
            listOf("1", "2", "3", "4", "5")
        ),
        PagerTaskModel.Pending(
            listOf("11", "12", "13", "14", "15")
        ),
        PagerTaskModel.PhotoWithText(
            R.drawable.ic_launcher_background,
            "Photo With Text"
        ),
//        PagerTaskModel.PhotoWithButton(
//            R.drawable.ic_launcher_background,
//            "Next"
//        ),
    )


}