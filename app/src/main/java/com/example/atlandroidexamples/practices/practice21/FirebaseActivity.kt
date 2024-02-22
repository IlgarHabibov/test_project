package com.example.atlandroidexamples.practices.practice21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.cache.SharedPrefs
import com.example.atlandroidexamples.databinding.ActivityFirebaseBinding
import com.example.atlandroidexamples.databinding.ActivityPractice10Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirebaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityFirebaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val type = intent?.getStringExtra("type")
        val id = intent?.getStringExtra("id")
        checkStartDestination(type, id)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val type = intent?.getStringExtra("type")
        val id = intent?.getStringExtra("id")
        checkStartDestination(type, id)

    }


    private fun checkStartDestination(type: String?, id: String?){
        val navHost = supportFragmentManager
            .findFragmentById(R.id.firebaseContainer) as NavHostFragment
        Log.d("FirebaseActivityTAG", "type: $type")
        Log.d("FirebaseActivityTAG", "id $id: ")
        val controller = navHost.navController
        if (type == "Details") {
            controller.navigate(R.id.noteDetailsFragment, bundleOf("id" to id))

        }
    }

}