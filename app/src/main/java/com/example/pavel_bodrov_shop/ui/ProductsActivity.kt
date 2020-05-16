package com.example.pavel_bodrov_shop.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pavel_bodrov_shop.App
import com.example.pavel_bodrov_shop.R
import com.example.pavel_bodrov_shop.domain.model.Category
import com.example.pavel_bodrov_shop.domain.model.Product
import com.example.pavel_bodrov_shop.presenter.ProductsPresenter
import com.example.pavel_bodrov_shop.presenter.ProductsView
import kotlinx.android.synthetic.main.footer_layout.*
import kotlinx.android.synthetic.main.header_layout.*
import kotlinx.android.synthetic.main.products_layout.*
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class ProductsActivity: BaseActivity(), ProductsView {
    @Inject
    lateinit var productsPresenter: ProductsPresenter

    private val presenter by moxyPresenter { productsPresenter }

    private val categoryProductsAdapter = CategoryProductsAdapter {
            product -> presenter.showProductInfo(product)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.products_layout)

        val category = intent?.getParcelableExtra<Category>(CATEGORY_TAG) ?: return

        headerBackButton.setOnClickListener { finish() }
        footerCatalogButton.setOnClickListener { startActivity(Intent(this, CatalogActivity::class.java)) }
        footerCartButton.setOnClickListener { startActivity(Intent(this, CartActivity::class.java)) }
        footerContactsButton.setOnClickListener { startActivity(Intent(this, ContactsActivity::class.java)) }

        headerTv.text = category.name
        categoryProductsRv.layoutManager = LinearLayoutManager(this)
        categoryProductsRv.adapter = categoryProductsAdapter

        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(applicationContext,R.drawable.recyclerview_divider)!!)
        categoryProductsRv.addItemDecoration(dividerItemDecoration)

        presenter.setProducts(category)
    }

    override fun setProducts(products: List<Product>) {
        categoryProductsAdapter.setData(products)
    }

    override fun showProductInfo(product: Product) {
        startActivity(Intent(this, ProductInfoActivity::class.java).apply {
            putExtra(ProductInfoActivity.PRODUCT_TAG, product)
        })
    }

    override fun setDummy(products: List<Product>) {
        Toast.makeText(this, "Prod 1: ${products[0].name} Prod 2: ${products[1].name}", Toast.LENGTH_LONG).show()
    }

    companion object {
        const val CATEGORY_TAG = "CATEGORY_TAG"
    }
}