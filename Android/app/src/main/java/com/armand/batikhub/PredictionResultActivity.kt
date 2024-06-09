package com.armand.batikhub

import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class PredictionResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prediction_result)

        val imageViewScannedBatik: ImageView = findViewById(R.id.imageViewScannedBatik)
        val imageUri = intent.getStringExtra("imageUri")?.let { Uri.parse(it) }
        imageViewScannedBatik.setImageURI(imageUri)
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("batik")

        // Contoh data, asumsikan ini hasil prediksi
        val batikItem = BatikItem("Batik Kawung", "Deskripsi batik kawung", "url_gambar_batik_kawung")
        myRef.push().setValue(batikItem)

    }
}