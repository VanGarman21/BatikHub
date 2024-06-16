package com.armand.batikhub.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.armand.batikhub.R
import com.armand.batikhub.model.Batik
import com.bumptech.glide.Glide

class HomeAdapter(private val onClick: (Batik) -> Unit) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private var batikList = listOf<Batik>()

    @SuppressLint("NotifyDataSetChanged")
    fun setBatikList(batikList: List<Batik>) {
        this.batikList = batikList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val batik = batikList[position]
        holder.textViewMotifBatik.text = batik.name
        // Load image using Glide or similar library
        Glide.with(holder.itemView.context)
            .load(batik.image)
            .into(holder.imageViewBatik)
        holder.itemView.setOnClickListener { onClick(batik) }
    }

    override fun getItemCount(): Int = batikList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewBatik: ImageView = itemView.findViewById(R.id.imageViewBatik)
        val textViewMotifBatik: TextView = itemView.findViewById(R.id.textViewMotifBatik)
    }
}