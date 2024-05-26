package com.armand.batikhub.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.armand.batikhub.R

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageViewBatik)
        val textViewMotifBatik: TextView = itemView.findViewById(R.id.textViewMotifBatik)
        val textViewAsalDaerah: TextView = itemView.findViewById(R.id.textViewAsalDaerah)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind data ke ViewHolder
    }

    override fun getItemCount(): Int {
        return 10 // Ganti dengan jumlah item yang sebenarnya
    }
}