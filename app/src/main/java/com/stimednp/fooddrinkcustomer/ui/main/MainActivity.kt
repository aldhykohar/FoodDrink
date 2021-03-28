package com.stimednp.fooddrinkcustomer.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stimednp.fooddrinkcustomer.R
import com.stimednp.fooddrinkcustomer.databinding.ActivityMainBinding
import com.stimednp.fooddrinkcustomer.ui.favorite.FavoriteFragment
import com.stimednp.fooddrinkcustomer.ui.home2.HomeFragment
import com.stimednp.fooddrinkcustomer.ui.order.OrderFragment


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        doInitialization(savedInstanceState)

    }

    private fun doInitialization(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.nav_host_fragment,
                HomeFragment(), "Home"
            ).commit()
        }
        binding.navBottom.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, HomeFragment(), "Home").commit()
                R.id.menu_order -> supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, OrderFragment(), "Order").commit()
                R.id.menu_favorite -> supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, FavoriteFragment(), "Favrite").commit()
            }
            true
        }
    }
}
