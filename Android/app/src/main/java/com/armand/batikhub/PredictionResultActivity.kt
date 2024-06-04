package com.armand.batikhub

import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PredictionResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prediction_result)

        val imageViewScannedBatik: ImageView = findViewById(R.id.imageViewScannedBatik)
        val imageUri = intent.getStringExtra("imageUri")?.let { Uri.parse(it) }
        imageViewScannedBatik.setImageURI(imageUri)
    }
}