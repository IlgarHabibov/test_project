package com.example.atlandroidexamples.practices.practice

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.activities.ThirdActivity
import com.example.atlandroidexamples.adapters.CoffeeAdapter
import com.example.atlandroidexamples.databinding.ActivityListBinding
import com.example.atlandroidexamples.model.Coffee
import com.example.atlandroidexamples.utils.SpaceItemDecoration
import com.google.android.material.divider.MaterialDivider
import com.google.android.material.divider.MaterialDividerItemDecoration

class ListActivity : AppCompatActivity() {

    private var binding: ActivityListBinding? = null
//    private val adapter = SettingsAdapter(createSettingsList())

    private val adapter = CoffeeAdapter(createCoffeeList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initRecyclerView()



    }

    private fun initRecyclerView() {
        binding?.settingsList?.adapter = adapter
        binding?.settingsList?.layoutManager = LinearLayoutManager(
            this,
            GridLayoutManager.HORIZONTAL,
            false
        )
        binding?.settingsList?.setOnClickListener {

        }
        val space = SpaceItemDecoration(resources.getDimensionPixelSize(R.dimen.dimen_10dp))
        binding?.settingsList?.addItemDecoration(space)




        adapter.setItemClickListener(object : CoffeeAdapter.OnItemClickListener{
            override fun onItemClick(coffee: Coffee) {

            }
        })


        adapter.setClickListener(::changeScreen)

    }

    private fun changeScreen(coffee: Coffee){
        val intent = Intent(this, ThirdActivity::class.java)
        intent.putExtra("name", coffee.name)
        intent.putExtra("desc", coffee.desc)
        intent.putExtra("rating", coffee.rating)
        intent.putExtra("price", coffee.price)
        intent.putExtra("imageId", coffee.iconId)
        startActivity(intent)
    }

    private fun createSettingsList() = listOf(
        com.example.atlandroidexamples.practices.practice.SettingsModel(
            name = "Language",
            R.drawable.ic_language
        ),
        com.example.atlandroidexamples.practices.practice.SettingsModel(
            name = "Notification",
            R.drawable.ic_notifications
        ),
        com.example.atlandroidexamples.practices.practice.SettingsModel(
            name = "Terms of Use",
            R.drawable.ic_terms_of_use
        ),
        com.example.atlandroidexamples.practices.practice.SettingsModel(
            name = "Privacy Policy",
            R.drawable.ic_privacy_policy
        ),
        com.example.atlandroidexamples.practices.practice.SettingsModel(
            name = "Chat support",
            R.drawable.ic_chat
        ),
    )


    private fun createCoffeeList() = mutableListOf(
        Coffee("Coffee1","good1", 3.1,"4.1", R.drawable.ic_language),
        Coffee("Coffee2","good2", 3.2,"4.2", R.drawable.ic_chat),
        Coffee("Coffee3","good3", 3.3,"4.3", R.drawable.ic_notifications),
        Coffee("Coffee4","good4", 3.4,"4.4", R.drawable.ic_privacy_policy),
        Coffee("Coffee5","good5", 3.5,"4.5", R.drawable.ic_terms_of_use),
        Coffee("Coffee6","good6", 3.6,"4.6", R.drawable.baseline_done_24),

        )

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}