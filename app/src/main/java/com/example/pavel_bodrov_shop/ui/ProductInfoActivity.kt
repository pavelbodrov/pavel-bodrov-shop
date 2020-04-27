package com.example.pavel_bodrov_shop.ui

import android.content.Intent
import android.os.Bundle
import com.example.pavel_bodrov_shop.R
import com.example.pavel_bodrov_shop.data.ViewedProductDaoImpl
import com.example.pavel_bodrov_shop.domain.model.Product
import com.example.pavel_bodrov_shop.presenter.ProductInfoPresenter
import com.example.pavel_bodrov_shop.presenter.ProductInfoView
import kotlinx.android.synthetic.main.product_info_layout.*
import moxy.ktx.moxyPresenter

class ProductInfoActivity: BaseActivity(), ProductInfoView {
    private val presenter by moxyPresenter {
        ProductInfoPresenter(
            ViewedProductDaoImpl(sharedPreferences)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_info_layout)

        val product = intent?.getParcelableExtra<Product>(PRODUCT_TAG) ?: return

        productInfoToCartButton.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
        productInfoBackButton.setOnClickListener { finish() }

        productNameTv.text = product.productName
        presenter.onProductShow(product)

    }

    companion object {
        const val PRODUCT_TAG = "PRODUCT_TAG"
    }
}