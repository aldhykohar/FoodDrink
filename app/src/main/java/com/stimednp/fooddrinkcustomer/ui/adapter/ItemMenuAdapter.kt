package com.stimednp.fooddrinkcustomer.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stimednp.fooddrinkcustomer.databinding.ItemContainerMenuBinding
import com.stimednp.fooddrinkcustomer.databinding.ItemContainerPopularBinding

class ItemMenuAdapter(
    var mContext: Context
) :
    RecyclerView.Adapter<ItemMenuAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemContainerMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int = 10


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind()
    }

    class ItemViewHolder(private val binding: ItemContainerMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getItemViewType(position: Int): Int {
        return position
    }
}