package com.stimednp.fooddrinkcustomer.ui.home.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.stimednp.fooddrinkcustomer.R
import com.stimednp.fooddrinkcustomer.databinding.FragmentDrinkBinding
import com.stimednp.fooddrinkcustomer.ui.adapter.ProdukItemAdapter
import com.stimednp.fooddrinkcustomer.ui.home.FoodDrinkListener
import com.stimednp.fooddrinkcustomer.ui.model.ProdukModel
import kotlin.math.log

class DrinkFragment : Fragment(), FoodDrinkListener {

    private var binding: FragmentDrinkBinding? = null
    private val listItem = ArrayList<ProdukModel>()
    private lateinit var viewModel: FoodDrinkViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDrinkBinding.inflate(inflater, container, false)
        doInitialization()
        return binding!!.root

    }

    private fun doInitialization() {
        viewModel = ViewModelProvider(this).get(FoodDrinkViewModel::class.java)
        binding!!.rvDrink.setHasFixedSize(true)
        listItem.addAll(getListHeroes())
        showRecyclerList()
        getDataBasket()

    }

    private fun getDataBasket() {
        viewModel.getAllBasketObservers().observe(viewLifecycleOwner, Observer {
            Log.e("DATA", "getDataBasket: $it")
        })
    }

    private fun insertData(model: ProdukModel) {
        val produkModel = ProdukModel(model.id, model.title, model.image, model.price, model.count)
        viewModel.insertDataBasket(produkModel)
    }

    fun getListHeroes(): ArrayList<ProdukModel> {
        val dataName = resources.getStringArray(R.array.data_drink_name)
        val dataPrice = resources.getStringArray(R.array.data_drink_price)
        val dataPhoto = resources.getStringArray(R.array.data_drink_image)
        val dataId = resources.getStringArray(R.array.data_drink_id)
        val listProduk = ArrayList<ProdukModel>()
        for (position in dataName.indices) {
            val hero = ProdukModel(
                dataId[position],
                dataName[position],
                dataPhoto[position],
                dataPrice[position],
                1
            )
            listProduk.add(hero)
        }
        return listProduk
    }

    private fun showRecyclerList() {
        binding!!.rvDrink.layoutManager = LinearLayoutManager(context)
        val adapter = context?.let { ProdukItemAdapter(it, listItem, this) }
        binding!!.rvDrink.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onPlusClicked(model: ProdukModel) {

    }

    override fun onMinusClicked(model: ProdukModel) {
        TODO("Not yet implemented")
    }

    override fun onAddClicked(model: ProdukModel) {
        Toast.makeText(context, model.title + " ditambahkan ke keranjang", Toast.LENGTH_SHORT)
            .show()
        insertData(model)
    }

}