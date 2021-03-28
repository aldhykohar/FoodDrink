package com.stimednp.fooddrinkcustomer.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stimednp.fooddrinkcustomer.databinding.ItemContainerPopularBinding
import com.stimednp.fooddrinkcustomer.databinding.ItemContainerProdukItemBinding
import com.stimednp.fooddrinkcustomer.ui.home.FoodDrinkListener
import com.stimednp.fooddrinkcustomer.ui.model.ProdukModel

class ItemPopularAdapter(
    var mContext: Context
) :
    RecyclerView.Adapter<ItemPopularAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemContainerPopularBinding.inflate(
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

    class ItemViewHolder(private val binding: ItemContainerPopularBinding) :
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