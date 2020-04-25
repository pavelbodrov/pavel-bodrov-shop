package com.example.pavel_bodrov_shop.ui

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pavel_bodrov_shop.R
import com.example.pavel_bodrov_shop.model.Product
import com.example.pavel_bodrov_shop.presenter.CartPresenter
import com.example.pavel_bodrov_shop.presenter.CartView
import kotlinx.android.synthetic.main.cart_layout.*
import kotlinx.android.synthetic.main.catalog_layout.*

class CartActivity: BaseActivity(), CartView {

    private val presenter = CartPresenter()
    private val adapter = CartProductAdapter {
            product -> presenter.removeItem(product)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart_layout)

        cartToCheckoutButton.setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java))
        }
        cartBackButton.setOnClickListener { finish() }

        cartAddNewProductButton.setOnClickListener {
            presenter.addItem()
        }

        cartListRv.layoutManager = LinearLayoutManager(this)
        cartListRv.adapter = adapter
        presenter.attachView(this)
        presenter.setData()

    }

    override fun setProducts(list: List<Product>) {
        adapter.setData(list)
    }

    override fun removeItem(position: Int) {
        adapter.notifyItemRemoved(position)
    }

    override fun addItem(position: Int) {
        adapter.notifyItemInserted(position)
    }
}