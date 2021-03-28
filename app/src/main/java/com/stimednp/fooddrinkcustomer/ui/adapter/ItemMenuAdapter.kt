package com.stimednp.fooddrinkcustomer.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stimednp.fooddrinkcustomer.databinding.ItemContainerMenuBinding
import com.stimednp.fooddrinkcustomer.databinding.ItemContainerPopularBinding
import com.stimednp.fooddrinkcustomer.ui.detailpoduct.DetailProductActivity

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
        holder.bind(mContext)
    }

    class ItemViewHolder(private val binding: ItemContainerMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(context: Context) {
            with(binding) {
                container.setOnClickListener {
                    context.startActivity(Intent(context, DetailProductActivity::class.java))
                }
            }
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getItemViewType(position: Int): Int {
        return position
    }
}