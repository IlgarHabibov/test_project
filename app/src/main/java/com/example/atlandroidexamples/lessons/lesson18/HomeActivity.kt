package com.example.atlandroidexamples.lessons.lesson18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.ActivityHomeBinding
import com.example.atlandroidexamples.lessons.lesson19.MyBottomSheetFragment
import com.example.atlandroidexamples.lessons.lesson19.MyDialogFragment
import com.example.atlandroidexamples.lessons.lesson19.MyFragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragments = listOf(FirstFragment(), SecondFragment(), ThirdFragment())
        val adapter = MyFragmentStateAdapter(fragments ,supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        val mediator = TabLayoutMediator(binding.tabLayout, binding.viewPager){
            tab, position ->
            when(position){
                0 ->tab.text = "First"
                1 ->tab.text = "Second"
                2 ->tab.text = "Third"
            }
        }

        mediator.attach()

        binding.showDialog.setOnClickListener {

            val view = LayoutInflater.
            from(this).inflate(R.layout.fragment_my_dialog, binding.root, false)

            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("My Dialog")
                .setMessage("My Dialog Message")
                .setView(view)
                .setPositiveButton("Done"){_, _ ->
                    Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Close"){ _, _ ->
                    Toast.makeText(this, "Close", Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("Nothing"){_, _ ->
                    Toast.makeText(this, "Nothing", Toast.LENGTH_SHORT).show()

                }
                .create()
                .show()


        }

        supportFragmentManager.setFragmentResultListener(MyDialogFragment.MY_DIALOG_REQUEST_KEY, this){
            key, bundle ->
            val result = bundle.getString(MyDialogFragment.RESULT_KEY)
            when(result){
                MyDialogFragment.NEXT ->{
                    Toast.makeText(this, "NEXT", Toast.LENGTH_SHORT).show()
                }
                MyDialogFragment.CLOSE ->{
                    Toast.makeText(this, "ClOSE", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

    private fun changeMenu(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}