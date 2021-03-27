package com.stimednp.fooddrinkcustomer.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stimednp.fooddrinkcustomer.databinding.ActivityMainBinding
import com.stimednp.fooddrinkcustomer.utilities.showToast

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        doInitialization()

    }

    private fun doInitialization() {
        binding.navBottom.setOnNavigationItemSelectedListener {
            showToast(it.title.toString())
            true
        }
    }
}
