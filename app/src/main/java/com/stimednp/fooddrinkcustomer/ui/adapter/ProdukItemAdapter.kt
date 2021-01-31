package com.stimednp.fooddrinkcustomer.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stimednp.fooddrinkcustomer.databinding.ItemContainerProdukItemBinding
import com.stimednp.fooddrinkcustomer.ui.home.FoodDrinkListener
import com.stimednp.fooddrinkcustomer.ui.model.ProdukModel

class ProdukItemAdapter(
    var mContext: Context,
    var listProduk: List<ProdukModel>,
    val listener: FoodDrinkListener
) :
    RecyclerView.Adapter<ProdukItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemContainerProdukItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int = listProduk.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(mContext, listProduk[position], listener)
    }

    class ItemViewHolder(private val binding: ItemContainerProdukItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mContext: Context, produkModel: ProdukModel, listener: FoodDrinkListener) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(produkModel.image)
                    .into(ivItem)

                tvItemName.text = produkModel.title
                tvItemPrice.text = produkModel.price

                binding.mbTambah.setOnClickListener {
                    llCounter.visibility = VISIBLE
                    mbTambah.visibility = INVISIBLE
                    listener.onAddClicked(produkModel)
                }

                binding.ivPlus.setOnClickListener {
                    produkModel.count = produkModel.count + 1
                    tvCounter.text = produkModel.count.toString()
                }
                binding.ivMinus.setOnClickListener {
                    if (produkModel.count <= 1) {
                        mbTambah.visibility = VISIBLE
                        llCounter.visibility = INVISIBLE
                        Toast.makeText(
                            mContext,
                            produkModel.title + " dihapus dari keranjang",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        produkModel.count = produkModel.count - 1
                        tvCounter.text = produkModel.count.toString()
                    }
                }
            }
        }
    }
}