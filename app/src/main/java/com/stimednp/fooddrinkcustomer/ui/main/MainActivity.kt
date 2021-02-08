package com.stimednp.fooddrinkcustomer.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import com.stimednp.fooddrinkcustomer.databinding.ActivityMainBinding
import com.stimednp.fooddrinkcustomer.ui.home.HomeActivity
import com.stimednp.fooddrinkcustomer.ui.scanner.ScannerActivity
import com.stimednp.fooddrinkcustomer.utilities.showToast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mbScan.setOnClickListener {
//            val intentIntegrator = IntentIntegrator(this)
//            intentIntegrator.setBeepEnabled(false)
//            intentIntegrator.setOrientationLocked(true)
//            intentIntegrator.captureActivity = ScannerActivity::class.java
//            intentIntegrator.initiateScan()

            val intent = Intent(this, HomeActivity::class.java)
//            intent.putExtra("key", intentResult.contents)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if (intentResult.contents != null) {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("key", intentResult.contents)
            startActivity(intent)
        }
    }

}