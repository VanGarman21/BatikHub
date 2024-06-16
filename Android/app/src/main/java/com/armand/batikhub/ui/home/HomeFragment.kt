package com.armand.batikhub.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.armand.batikhub.R
import com.armand.batikhub.adapter.HomeAdapter
import com.armand.batikhub.api.ApiModule
import com.armand.batikhub.model.BatikResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchText: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchButton = view.findViewById<Button>(R.id.btn_search)
        searchButton.setOnClickListener {
            val searchText = view.findViewById<EditText>(R.id.et_query).text.toString()
            searchBatikByName(searchText)
        }

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = HomeAdapter { batik ->
            val intent = batik.id?.let { DetailActivity.newIntent(context, it) }
            if (intent != null) {
                startActivity(intent)
            }
        }
        fetchBatik()
    }

    private fun fetchBatik() {
        ApiModule.batikApi.getAllBatik().enqueue(object : Callback<BatikResponse> {
            override fun onResponse(call: Call<BatikResponse>, response: Response<BatikResponse>) {
                if (response.isSuccessful) {
                    val batikList = response.body()?.data ?: emptyList()
                    (recyclerView.adapter as HomeAdapter).setBatikList(batikList)
                } else {
                    Log.e("HomeFragment", "Error: ${response.message()}")
                    Toast.makeText(context, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<BatikResponse>, t: Throwable) {
                Log.e("HomeFragment", "Failure: ${t.message}")
                Toast.makeText(context, "Failure: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun searchBatikByName(name: String) {
        val requestBody = mapOf("name" to name)
        ApiModule.batikApi.getBatikByName(requestBody).enqueue(object : Callback<BatikResponse> {
            override fun onResponse(call: Call<BatikResponse>, response: Response<BatikResponse>) {
                if (response.isSuccessful) {
                    val batikList = response.body()?.data ?: emptyList()
                    (recyclerView.adapter as HomeAdapter).setBatikList(batikList)
                } else {
                    Toast.makeText(context, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<BatikResponse>, t: Throwable) {
                Toast.makeText(context, "Failure: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}