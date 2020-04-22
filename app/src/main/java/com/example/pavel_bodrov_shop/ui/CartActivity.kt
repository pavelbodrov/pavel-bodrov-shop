package com.example.pavel_bodrov_shop.ui

import android.content.Intent
import android.os.Bundle
import com.example.pavel_bodrov_shop.R
import kotlinx.android.synthetic.main.cart_layout.*

class CartActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart_layout)

        cartToCheckoutButton.setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java))
        }
        cartBackButton.setOnClickListener { finish() }

    }
}