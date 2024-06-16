package com.armand.batikhub

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.armand.batikhub.R
import com.armand.batikhub.database.BatikHistory

class BatikAdapter(private val batikList: List<BatikHistory>) : RecyclerView.Adapter<BatikAdapter.BatikViewHolder>() {

    class BatikViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val nameTextView: TextView = view.findViewById(R.id.name)
        val dateTextView: TextView = view.findViewById(R.id.textViewDateTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatikViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_batik, parent, false)
        return BatikViewHolder(view)
    }

    override fun onBindViewHolder(holder: BatikViewHolder, position: Int) {
        val batikHistory = batikList[position]
        Glide.with(holder.itemView.context)
            .load(Uri.parse(batikHistory.imageUri))
            .into(holder.imageView)
        holder.nameTextView.text = "${batikHistory.label} : ${batikHistory.percentage}%"
        holder.dateTextView.text = batikHistory.date
    }

    override fun getItemCount(): Int = batikList.size
}