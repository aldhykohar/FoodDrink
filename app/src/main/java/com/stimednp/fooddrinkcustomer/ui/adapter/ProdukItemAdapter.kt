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
import com.stimednp.fooddrinkcustomer.databinding.ItemContainerProdukItemBinding
import com.stimednp.fooddrinkcustomer.ui.home.FoodDrinkListener
import com.stimednp.fooddrinkcustomer.ui.model.ProdukModel

class ProdukItemAdapter(
    var mContext: Context,
    var listProduk: List<ProdukModel>,
    val listener: FoodDrinkListener
) :
    RecyclerView.Adapter<ProdukItemAdapter.ItemViewHolder>() {

    private val mList: List<ProdukModel> = listProduk

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
//        holder.setIsRecyclable(false)
        holder.bind(mContext, mList[position], listener)
    }

    class ItemViewHolder(private val binding: ItemContainerProdukItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            mContext: Context,
            produkModel: ProdukModel,
            listener: FoodDrinkListener
        ) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(produkModel.image)
                    .into(ivItem)

                tvItemName.text = produkModel.title
                tvItemPrice.text = produkModel.price

                mbTambah.setOnClickListener {
                    llCounter.visibility = VISIBLE
                    mbTambah.visibility = INVISIBLE
                    listener.onAddClicked(produkModel)
                }

                ivPlus.setOnClickListener {
                    produkModel.count = produkModel.count + 1
                    tvCounter.text = produkModel.count.toString()
                }
                ivMinus.setOnClickListener {
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

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getItemViewType(position: Int): Int {
        return position
    }
}