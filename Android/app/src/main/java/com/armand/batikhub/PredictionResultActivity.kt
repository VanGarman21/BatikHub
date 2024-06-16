package com.armand.batikhub

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.armand.batikhub.database.AppDatabase
import com.armand.batikhub.database.BatikHistory
import com.armand.batikhub.model.PredictionResultResponse

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

            // Simpan ke database
            val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "batikhub").build()
            val batikHistory = BatikHistory(
                imageUri = imageUri.toString(),
                label = result.label ?: "",
                percentage = result.percentage ?: 0,
                date = result.date ?: "",
                description = result.desc ?: ""
            )
            Thread {
                db.batikHistoryDao().insert(batikHistory)
            }.start()

        } else {
            // Handle the case where result is null
            findViewById<TextView>(R.id.textViewPredictionResult).text = "Prediction result is null"
        }
    }
}