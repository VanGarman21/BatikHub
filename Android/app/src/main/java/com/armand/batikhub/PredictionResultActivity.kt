package com.armand.batikhub

import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.armand.batikhub.model.PredictionResultResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class PredictionResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prediction_result)

        supportActionBar?.hide()

        window.statusBarColor = Color.WHITE

        // Set status bar text to black (light status bar icons)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

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
            val currentUser = FirebaseAuth.getInstance().currentUser
            val userId = currentUser?.uid ?: "Unknown User"
            val batikItem = BatikItem(name, imageUrl, date, userId)
            myRef.push().setValue(batikItem)
        } else {
            // Handle the case where result is null
            findViewById<TextView>(R.id.textViewPredictionResult).text = "Prediction result is null"
        }
    }
}