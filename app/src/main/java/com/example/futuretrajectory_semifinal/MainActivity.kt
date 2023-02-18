package com.example.futuretrajectory_semifinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.futuretrajectory_semifinal.feature_vkservicelist.presentation.ui.VKServiceListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_container, VKServiceListFragment())
            .commit()
    }
}