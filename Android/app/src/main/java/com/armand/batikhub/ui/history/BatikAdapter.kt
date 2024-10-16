package com.armand.batikhub.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.armand.batikhub.BatikItem
import com.armand.batikhub.databinding.ItemBatikBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class BatikAdapter(private val batikList: List<BatikItem>) : RecyclerView.Adapter<BatikAdapter.BatikViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatikViewHolder {
        val binding = ItemBatikBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BatikViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BatikViewHolder, position: Int) {
        with(holder) {
            with(batikList[position]) {
                binding.name.text = name
                binding.textViewDateTime.text = date
                // Memuat gambar menggunakan Glide
                if (imageUrl != null) {


                    Glide.with(holder.itemView.context)
                        .load(imageUrl)
                        .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(16)))
                        .into(binding.imageView)
                }
            }
        }
    }

    override fun getItemCount(): Int = batikList.size

    class BatikViewHolder(val binding: ItemBatikBinding) : RecyclerView.ViewHolder(binding.root)
}