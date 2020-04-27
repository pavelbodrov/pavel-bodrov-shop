package com.example.pavel_bodrov_shop.ui

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pavel_bodrov_shop.presenter.CatalogPresenter
import com.example.pavel_bodrov_shop.R
import com.example.pavel_bodrov_shop.data.ViewedProductDaoImpl
import com.example.pavel_bodrov_shop.domain.model.Product
import com.example.pavel_bodrov_shop.presenter.CatalogView
import kotlinx.android.synthetic.main.catalog_layout.*
import moxy.ktx.moxyPresenter

class CatalogActivity: BaseActivity(),
    CatalogView {

    private val presenter by moxyPresenter {
        CatalogPresenter(ViewedProductDaoImpl(sharedPreferences))
    }
    private val categoryAdapter = CategoryAdapter {
            category -> presenter.removeItem(category)
    }

    private val lastViewedAdapter = LastViewedAdapter {
            product -> presenter.showProductInfo(product)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalog_layout)

            catalogToCartButton.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        categoryRv.layoutManager = LinearLayoutManager(this)
        categoryRv.adapter = categoryAdapter

        viewedProductsRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        viewedProductsRv.adapter = lastViewedAdapter
    }

    override fun setCategories(list: List<String>) {
        categoryAdapter.setData(list)
    }

    override fun setLastViewed(products: List<Product>) {
        lastViewedAdapter.setData(products)
    }

    override fun removeItem(position: Int) {
        categoryAdapter.notifyItemRemoved(position)
    }

    override fun showProductIds(productIds: List<Long>) {
//        val names = productIds.map{ presenter.getProductById(it).productName }
//        Toast.makeText(this, names.joinToString(","), Toast.LENGTH_LONG).show()
    }

    override fun showProductInfo(product: Product) {
        startActivity(Intent(this, ProductInfoActivity::class.java).apply {
            putExtra(ProductInfoActivity.PRODUCT_TAG, product)
        })
    }
}

val AppCompatActivity.sharedPreferences: SharedPreferences
    get() = getSharedPreferences("data", MODE_PRIVATE)