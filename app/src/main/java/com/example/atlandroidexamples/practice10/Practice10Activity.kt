package com.example.atlandroidexamples.practice10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.atlandroidexamples.R
import com.example.atlandroidexamples.databinding.ActivityPractice10Binding
import com.example.atlandroidexamples.utils.SharedPrefs

class Practice10Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPractice10Binding.inflate(layoutInflater)
        setContentView(binding.root)
        SharedPrefs.setPrefs(getSharedPreferences("Settings",MODE_PRIVATE))
        val navHost = supportFragmentManager
            .findFragmentById(R.id.p10MainContainer) as NavHostFragment

        val firstGraphDone = SharedPrefs.getBool(SharedPrefs.FIRST_GRAPH_DONE)
        val secondGraphDone = SharedPrefs.getBool(SharedPrefs.SECOND_GRAPH_DONE)

        if(firstGraphDone == true){
            val controller = navHost.navController
            if (secondGraphDone != true){
                val graph = controller.navInflater.inflate(R.navigation.p10_second_graph)
                controller.setGraph(graph, null)
            }else {
                val graph = controller.navInflater.inflate(R.navigation.p10_third_graph)
                controller.setGraph(graph, null)
            }


        }

    }
}