package com.armand.batikhub

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.armand.batikhub.model.PredictionResultResponse
import com.google.firebase.database.FirebaseDatabase

class PredictionResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prediction_result)

        val imageUri = intent.getStringExtra("imageUri")
        val imageView = findViewById<ImageView>(R.id.imageViewScannedBatik)
        imageView.setImageURI(Uri.parse(imageUri))

        val result = intent.getSerializableExtra("predictionResult") as? PredictionResultResponse

        if (result != null) {
            findViewById<TextView>(R.id.textViewPredictionResult).text = "${result.label} : ${result.percentage}%"
            findViewById<TextView>(R.id.textView6).text = result.date
            findViewById<TextView>(R.id.textView7).text = result.desc

            val name = "${result.label} - ${result.percentage}%"
            val date = result.date ?: "No date provided"
            val imageUrl = imageUri ?: "No image"

            // Save to Firebase
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference("batik")
            val batikItem = BatikItem(name, imageUrl, date)
            myRef.push().setValue(batikItem)
        } else {
            // Handle the case where result is null
            findViewById<TextView>(R.id.textViewPredictionResult).text = "Prediction result is null"
        }
    }
}