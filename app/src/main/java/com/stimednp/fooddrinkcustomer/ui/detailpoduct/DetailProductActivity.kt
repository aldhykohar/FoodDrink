package com.stimednp.fooddrinkcustomer.ui.detailpoduct

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.stimednp.fooddrinkcustomer.R
import com.stimednp.fooddrinkcustomer.databinding.ActivityDetailProductBinding

class DetailProductActivity : AppCompatActivity() {

    var isFav = true

    private val binding: ActivityDetailProductBinding by lazy {
        ActivityDetailProductBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        doInitialization()
        doOnClick()
    }

    private fun doInitialization() {
//        makeStatusBarTransparent()
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.container)) { _, insets ->
            binding.ivBack.setMarginTop(insets.systemWindowInsetTop)
            insets.consumeSystemWindowInsets()
        }*/
    }

    private fun doOnClick() {
        with(binding) {
            ivBack.setOnClickListener { onBackPressed() }
            ivFavorite.setOnClickListener {
                if (isFav) {
                    isFav = false
                    ivFavorite.imageTintList = ContextCompat.getColorStateList(
                        this@DetailProductActivity,
                        R.color.colorGreyDark
                    )
                } else {
                    isFav = true
                    ivFavorite.imageTintList = ContextCompat.getColorStateList(
                        this@DetailProductActivity,
                        R.color.colorYellow
                    )
                }
            }
        }
    }
}