package com.stimednp.fooddrinkcustomer.ui.home2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stimednp.fooddrinkcustomer.R
import com.stimednp.fooddrinkcustomer.databinding.FragmentHomeBinding
import com.stimednp.fooddrinkcustomer.ui.adapter.ItemCategoryAdapter
import com.stimednp.fooddrinkcustomer.ui.adapter.ItemMenuAdapter
import com.stimednp.fooddrinkcustomer.ui.adapter.ItemPopularAdapter
import com.stimednp.fooddrinkcustomer.ui.keranjang.CartActivity

class HomeFragment : Fragment(), HomeListener {

    private var popularAdapter: ItemPopularAdapter? = null
    private var categoryAdapter: ItemCategoryAdapter? = null
    private var menuAdapter: ItemMenuAdapter? = null
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doInitialization()
        doOnClick()
    }

    private fun doInitialization() {
        val itemCategory = resources.getStringArray(R.array.item_category).toList()
        context?.let {
            popularAdapter = ItemPopularAdapter(it)
            menuAdapter = ItemMenuAdapter(it)
            categoryAdapter = ItemCategoryAdapter(it, this, itemCategory)
        }
        with(binding) {
            rvPopular.run {
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = popularAdapter
            }

            rvCategory.run {
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = categoryAdapter
            }

            rvMenu.run {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = menuAdapter
            }

        }
    }

    private fun doOnClick() {
        binding.run {
            ivCart.setOnClickListener {
                startActivity(Intent(context, CartActivity::class.java))
            }
        }
    }

    override fun itemCategoryClick(position: Int) {
        categoryAdapter?.run {
            notifyDataSetChanged()
            checkedPosition = position
        }
    }


}