package com.stimednp.fooddrinkcustomer.ui.scanner

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import com.journeyapps.barcodescanner.CaptureManager
import com.journeyapps.barcodescanner.DecoratedBarcodeView
import com.journeyapps.barcodescanner.ViewfinderView
import com.stimednp.fooddrinkcustomer.R
import com.stimednp.fooddrinkcustomer.databinding.ActivityScannerBinding


class ScannerActivity : Activity(), DecoratedBarcodeView.TorchListener {

    private lateinit var binding: ActivityScannerBinding
    private var viewfinderView: ViewfinderView? = null
    private var capture: CaptureManager? = null

    private var isLight = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScannerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewfinderView = findViewById(R.id.zxing_viewfinder_view)

        binding.barcodeScanner.setTorchListener(this)

        if (!hasFlash()) {
            binding.ivFlash.visibility = View.GONE
        }

        capture = CaptureManager(this, binding.barcodeScanner)
        capture!!.initializeFromIntent(intent, savedInstanceState)
        capture!!.decode()
    }

    override fun onResume() {
        super.onResume()
        capture!!.onResume()
    }

    override fun onPause() {
        super.onPause()
        capture!!.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        capture!!.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState!!)
        capture!!.onSaveInstanceState(outState)
    }

    private fun hasFlash(): Boolean {
        return applicationContext.packageManager
            .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)
    }

    fun switchFlashlight(view: View?) {
        if (isLight) {
            binding.barcodeScanner.setTorchOn()
        } else {
            binding.barcodeScanner.setTorchOff()
        }
    }

    fun back(view: View?) {
        onBackPressed()
    }

    override fun onTorchOn() {
        isLight = false
        binding.ivFlash.setImageResource(R.drawable.ic_flash_off)
    }

    override fun onTorchOff() {
        isLight = true
        binding.ivFlash.setImageResource(R.drawable.ic_flash_on)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        capture!!.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}