package com.example.pavel_bodrov_shop.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.pavel_bodrov_shop.App
import com.example.pavel_bodrov_shop.R
import com.example.pavel_bodrov_shop.domain.model.Product
import com.example.pavel_bodrov_shop.presenter.ProductInfoPresenter
import com.example.pavel_bodrov_shop.presenter.ProductInfoView
import kotlinx.android.synthetic.main.category_products_item.view.*
import kotlinx.android.synthetic.main.footer_layout.*
import kotlinx.android.synthetic.main.header_layout.*
import kotlinx.android.synthetic.main.product_info_layout.*
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class ProductInfoActivity: BaseActivity(), ProductInfoView {

    @Inject
    lateinit var productInfoPresenter: ProductInfoPresenter

    private val presenter by moxyPresenter { productInfoPresenter }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_info_layout)

        val product = intent?.getParcelableExtra<Product>(PRODUCT_TAG) ?: return

        headerAddToCartButton.visibility = View.VISIBLE

        headerAddToCartButton.setOnClickListener {
//            startActivity(Intent(this, CartActivity::class.java))
            presenter.onAddToCartClick(product)
            Toast.makeText(this, "Добавлено", Toast.LENGTH_SHORT).show()
        }
        headerBackButton.setOnClickListener { finish() }
        footerCatalogButton.setOnClickListener { startActivity(Intent(this, CatalogActivity::class.java)) }
        footerCartButton.setOnClickListener { startActivity(Intent(this, CartActivity::class.java)) }
        footerContactsButton.setOnClickListener { startActivity(Intent(this, ContactsActivity::class.java)) }

        Glide
            .with(this)
            .load(product.imageUrl)
            .error(R.mipmap.ic_launcher)
            .into(productsInfoIv)
        headerTv.text = product.name
        productPriceTv.text = "${product.price} Р"
        productDescription.text = product.description

        presenter.onProductShow(product)

    }

    companion object {
        const val PRODUCT_TAG = "PRODUCT_TAG"
    }
}