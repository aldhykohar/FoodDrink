package com.stimednp.fooddrinkcustomer.ui.home.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.stimednp.fooddrinkcustomer.R
import com.stimednp.fooddrinkcustomer.databinding.FragmentDrinkBinding
import com.stimednp.fooddrinkcustomer.ui.adapter.ProdukItemAdapter
import com.stimednp.fooddrinkcustomer.ui.home.FoodDrinkListener
import com.stimednp.fooddrinkcustomer.ui.home.HomeActivity
import com.stimednp.fooddrinkcustomer.ui.model.ProdukModel
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class DrinkFragment : Fragment(), FoodDrinkListener, KodeinAware {

    override val kodein by kodein()

    private lateinit var binding: FragmentDrinkBinding
    private val listItem = ArrayList<ProdukModel>()
    private lateinit var viewModel: FoodDrinkViewModel

    private val factory: FoodDrinkViewModelProvider by instance()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDrinkBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doInitialization()

    }

    private fun doInitialization() {
        viewModel = ViewModelProvider(
            this, factory
        ).get(FoodDrinkViewModel::class.java)
        binding.rvDrink.setHasFixedSize(true)
        listItem.addAll(getListHeroes())
        showRecyclerList()
        getDataBasket()

    }

    private fun getDataBasket() {
        lifecycleScope.launch {
            val response = viewModel.getDataBasket()
            Log.e("DATA", "getDataBasket: $response")
        }
    }

    private fun insertData(model: ProdukModel) {
        val produkModel = ProdukModel(model.id, model.title, model.image, model.price, model.count)

        lifecycleScope.launch {
            viewModel.addItemToBasket(produkModel)
        }

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
        binding.rvDrink.layoutManager = LinearLayoutManager(context)
        binding.rvDrink.setHasFixedSize(false)
        val adapter = context?.let { ProdukItemAdapter(it, listItem, this) }
        binding.rvDrink.adapter = adapter
    }

    fun updateOrder(model: ProdukModel, count: Int) {
        val position = (HomeActivity).listOrder.indexOf(model)
        (HomeActivity).listOrder[position].count = count
    }

    override fun onPlusClicked(model: ProdukModel, count: Int) {
        updateOrder(model, count)
    }

    override fun onMinusClicked(model: ProdukModel, count: Int) {
        updateOrder(model, count)
    }

    override fun onAddClicked(model: ProdukModel) {
//        Toast.makeText(context, model.title + " ditambahkan ke keranjang", Toast.LENGTH_SHORT)
//            .show()
//        insertData(model)

        (HomeActivity).listOrder.add(model)

    }

}