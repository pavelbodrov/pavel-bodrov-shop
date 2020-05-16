package com.example.pavel_bodrov_shop.ui

import android.content.Intent
import android.os.Bundle
import com.example.pavel_bodrov_shop.App
import com.example.pavel_bodrov_shop.R
import com.example.pavel_bodrov_shop.presenter.ProductInfoView
import kotlinx.android.synthetic.main.footer_layout.*
import kotlinx.android.synthetic.main.header_layout.*

class ContactsActivity: BaseActivity(), ProductInfoView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contacts_layout)

        headerTv.text = "Контакты"

        footerCatalogButton.setOnClickListener { startActivity(Intent(this, CatalogActivity::class.java)) }
        footerCartButton.setOnClickListener { startActivity(Intent(this, CartActivity::class.java)) }

        headerBackButton.setOnClickListener { finish() }
    }
}