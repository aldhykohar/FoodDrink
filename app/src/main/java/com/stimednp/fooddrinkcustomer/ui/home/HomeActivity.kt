package com.stimednp.fooddrinkcustomer.ui.home

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.stimednp.fooddrinkcustomer.databinding.ActivityHomeBinding
import com.stimednp.fooddrinkcustomer.ui.adapter.SectionPagerAdapter
import com.stimednp.fooddrinkcustomer.ui.home.fragment.DrinkFragment
import com.stimednp.fooddrinkcustomer.ui.home.fragment.FoodsFragment


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private var indicatorWidth = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        doInitialization()
    }

    private fun doInitialization() {
        val adapter = SectionPagerAdapter(supportFragmentManager)
        adapter.addFragment(DrinkFragment(), "Drink")
        adapter.addFragment(FoodsFragment(), "Foods")
        binding.viewPager.adapter = adapter
        binding.tab.setupWithViewPager(binding.viewPager)

        binding.tab.post {
            indicatorWidth = binding.tab.width / binding.tab.tabCount

            //Assign new width
            val indicatorParams =
                binding.indicator.layoutParams
            indicatorParams.width = indicatorWidth
            binding.indicator.layoutParams = indicatorParams
        }

        binding.viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                val params= binding.indicator.layoutParams as FrameLayout.LayoutParams

                //Multiply positionOffset with indicatorWidth to get translation

                //Multiply positionOffset with indicatorWidth to get translation
                val translationOffset: Float = (positionOffset + position) * indicatorWidth
                params.leftMargin= translationOffset.toInt()
                binding.indicator.layoutParams = params
            }

            override fun onPageSelected(position: Int) {

            }
        })
    }
}