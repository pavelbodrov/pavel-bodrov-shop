package com.example.pavel_bodrov_shop.ui

import android.content.Intent
import android.os.Bundle
import com.example.pavel_bodrov_shop.R
import kotlinx.android.synthetic.main.catalog_layout.*

class CatalogActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalog_layout)

        catalogToProductInfoButton.setOnClickListener {
            startActivity(Intent(this, ProductInfoActivity::class.java))
        }
    }
}