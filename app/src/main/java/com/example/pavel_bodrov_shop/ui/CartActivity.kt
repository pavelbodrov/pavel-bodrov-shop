package com.example.pavel_bodrov_shop.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pavel_bodrov_shop.App
import com.example.pavel_bodrov_shop.R
import com.example.pavel_bodrov_shop.domain.model.Product
import com.example.pavel_bodrov_shop.presenter.CartPresenter
import com.example.pavel_bodrov_shop.presenter.CartView
import com.example.pavel_bodrov_shop.ui.ProductInfoActivity.Companion.PRODUCT_TAG
import kotlinx.android.synthetic.main.cart_layout.*
import kotlinx.android.synthetic.main.footer_layout.*
import kotlinx.android.synthetic.main.header_layout.*
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class CartActivity: BaseActivity(), CartView {

    @Inject
    lateinit var cartPresenter: CartPresenter
    private val presenter by moxyPresenter { cartPresenter }

    private val adapter = CartProductAdapter (
        {productName -> presenter.removeItem(productName)},
        {product -> presenter.showProductInfo(product)}
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart_layout)

        headerBackButton.setOnClickListener { finish() }
        footerCatalogButton.setOnClickListener { startActivity(Intent(this, CatalogActivity::class.java)) }
        footerContactsButton.setOnClickListener { startActivity(Intent(this, ContactsActivity::class.java)) }


        cartCheckoutButton.setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java))
        }

        headerTv.text = "Корзина"

        cartListRv.layoutManager = LinearLayoutManager(this)
        cartListRv.adapter = adapter
        presenter.attachView(this)
        presenter.setData()

    }

    override fun setProducts(list: List<Product>) {
        val total = list.map {it.price}.sum()
        cartTotalDataTv.text = "${total/1000} т.р."
        adapter.setData(list)
    }

    override fun removeItem(position: Int, total: Double) {
        cartTotalDataTv.text = "${total/1000} т.р."
        if (total == 0.0) {
            cartCheckoutButton.visibility = View.INVISIBLE
        }
        else {
            cartCheckoutButton.visibility = View.VISIBLE
        }
        adapter.notifyItemRemoved(position)
    }

    override fun addItem(position: Int) {
        adapter.notifyItemInserted(position)
    }

    override fun showProductInfo(product: Product) {
        startActivity(Intent(this, ProductInfoActivity::class.java).apply {
            putExtra(PRODUCT_TAG, product)
        })
    }
}