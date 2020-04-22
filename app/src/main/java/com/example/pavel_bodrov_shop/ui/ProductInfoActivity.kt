package com.example.pavel_bodrov_shop.ui

import android.content.Intent
import android.os.Bundle
import com.example.pavel_bodrov_shop.R
import kotlinx.android.synthetic.main.product_info_layout.*

class ProductInfoActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_info_layout)

        productInfoToCartButton.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
        productInfoBackButton.setOnClickListener { finish() }

    }
}