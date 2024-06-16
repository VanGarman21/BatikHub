package com.armand.batikhub.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.armand.batikhub.R
import com.armand.batikhub.api.ApiModule
import com.armand.batikhub.model.Batik
import com.armand.batikhub.model.BatikResponse
import com.armand.batikhub.model.DetailBatik
import com.armand.batikhub.model.DetailBatikResponse
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    companion object {
        fun newIntent(context: Context?, batikId: String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("BATIK_ID", batikId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_batik)

        val batikId = intent.getStringExtra("BATIK_ID")
        Log.d("DetailActivity", "Received batik ID: $batikId")
        fetchDetailBatik(batikId)
    }

    private fun fetchDetailBatik(batikId: String?) {
        ApiModule.batikApi.getBatikById(batikId!!).enqueue(object : Callback<DetailBatikResponse> {
            override fun onResponse(call: Call<DetailBatikResponse>, response: Response<DetailBatikResponse>) {
                if (response.isSuccessful) {
                    val batik = response.body()?.data
                    if (batik != null) {
                        findViewById<TextView>(R.id.textView).text = batik.name
                        findViewById<TextView>(R.id.textView2).text = batik.regionalOrigin
                        findViewById<TextView>(R.id.textView3).text = batik.description

                        if (batik.image != null) {
                            Glide.with(this@DetailActivity)
                                .load(batik.image)
                                .into(findViewById(R.id.imageView2))
                        } else {
                            Log.e("DetailActivity", "Image URL is null")
                        }
                    } else {
                        Log.e("DetailActivity", "Batik data is null")
                    }
                } else {
                    Toast.makeText(this@DetailActivity, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                    Log.e("DetailActivity", "Error fetching batik details: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DetailBatikResponse>, t: Throwable) {
                Toast.makeText(this@DetailActivity, "Failure: ${t.message}", Toast.LENGTH_SHORT).show()
                Log.e("DetailActivity", "Failure fetching batik details: ${t.message}")
            }
        })
    }
}