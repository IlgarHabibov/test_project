package com.example.atlandroidexamples.practices.practice9

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.ActivityShopMainBinding
import com.example.atlandroidexamples.cache.SharedPrefs


class ShopMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShopMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE)
        SharedPrefs.setPrefs(sharedPreferences)


        val navHost = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        navController = navHost.navController


        binding.navigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, binding.drawerLayout)




//        binding.bottomNavView.setupWithNavController(navController)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.welcomeFragment2
            )
        )

//        navController.addOnDestinationChangedListener { navController, destination, bundle ->
//            if (destination.id != R.id.welcomeFragment2)
//            Toast.makeText(this, "fragment ${destination.label}", Toast.LENGTH_SHORT).show()
//        }



        binding.navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    navController.navigate(R.id.firstFragment2)
                    true
                }

                else -> {
                    false
                }
            }


        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
           android.R.id.home ->{
                binding.drawerLayout.openDrawer(Gravity.LEFT)
                true
            }

            else -> return super.onOptionsItemSelected(item)
        }

    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.bottom_menu, menu)
//        return true
//    }
}