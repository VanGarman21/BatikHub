package com.armand.batikhub

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.armand.batikhub.databinding.ItemBatikBinding

class BatikAdapter(private val batikList: List<BatikItem>) : RecyclerView.Adapter<BatikAdapter.BatikViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatikViewHolder {
        val binding = ItemBatikBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BatikViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BatikViewHolder, position: Int) {
        with(holder) {
            with(batikList[position]) {
                binding.name.text = name
                binding.description.text = description
                // Load image using Glide or similar library
            }
        }
    }

    override fun getItemCount(): Int = batikList.size

    class BatikViewHolder(val binding: ItemBatikBinding) : RecyclerView.ViewHolder(binding.root)
}