package com.stimednp.fooddrinkcustomer.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.stimednp.fooddrinkcustomer.R
import com.stimednp.fooddrinkcustomer.databinding.ItemContainerCategoryBinding
import com.stimednp.fooddrinkcustomer.ui.home2.HomeListener

class ItemCategoryAdapter(
    var mContext: Context,
    var listener: HomeListener,
    var list: List<String>
) :
    RecyclerView.Adapter<ItemCategoryAdapter.ItemViewHolder>() {

    var checkedPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemContainerCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(mContext, listener, checkedPosition, list[position])
    }

    class ItemViewHolder(private val binding: ItemContainerCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            context: Context,
            listener: HomeListener,
            checkedPosition: Int,
            item: String
        ) {
            with(binding) {
                tvCategory.text = item
                if (checkedPosition == adapterPosition) {
                    tvCategory.background = ContextCompat.getDrawable(
                        context,
                        R.drawable.background_yellow_rounded_14dp
                    )
                } else {
                    tvCategory.background = ContextCompat.getDrawable(
                        context,
                        R.drawable.background_primary_dark_rounded_14dp
                    )
                }

                tvCategory.setOnClickListener {
                    tvCategory.background = ContextCompat.getDrawable(
                        context,
                        R.drawable.background_yellow_rounded_14dp
                    )
                    listener.itemCategoryClick(adapterPosition)
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