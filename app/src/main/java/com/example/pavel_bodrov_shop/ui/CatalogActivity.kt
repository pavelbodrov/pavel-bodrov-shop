package com.example.pavel_bodrov_shop.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pavel_bodrov_shop.App
import com.example.pavel_bodrov_shop.presenter.CatalogPresenter
import com.example.pavel_bodrov_shop.R
import com.example.pavel_bodrov_shop.domain.model.Category
import com.example.pavel_bodrov_shop.domain.model.Product
import com.example.pavel_bodrov_shop.presenter.view.CatalogView
import com.example.pavel_bodrov_shop.ui.adapter.CategoryAdapter
import com.example.pavel_bodrov_shop.ui.adapter.LastViewedAdapter
import kotlinx.android.synthetic.main.catalog_layout.*
import kotlinx.android.synthetic.main.footer_layout.*
import kotlinx.android.synthetic.main.header_layout.*
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class CatalogActivity: BaseActivity(),
    CatalogView {

    @Inject
    lateinit var catalogPresenter: CatalogPresenter

    private val presenter by moxyPresenter { catalogPresenter }
    private val categoryAdapter =
        CategoryAdapter { category ->
            presenter.showProductsByCategory(category)
        }

    private val lastViewedAdapter =
        LastViewedAdapter { product ->
            presenter.showProductInfo(product)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalog_layout)

        headerBackButton.visibility = View.INVISIBLE
        headerTv.text = "Каталог"

        footerCartButton.setOnClickListener { startActivity(Intent(this, CartActivity::class.java)) }
        footerContactsButton.setOnClickListener { startActivity(Intent(this, ContactsActivity::class.java)) }

        categoryRv.layoutManager = LinearLayoutManager(this)
        categoryRv.adapter = categoryAdapter

        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(applicationContext,R.drawable.recyclerview_divider)!!)
        categoryRv.addItemDecoration(dividerItemDecoration)

        viewedProductsRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        viewedProductsRv.adapter = lastViewedAdapter
    }

    override fun setCategories(list: List<Category>) {
        categoryAdapter.setData(list)
    }

    override fun setLastViewed(products: List<Product>) {
        lastViewedAdapter.setData(products)
    }

    override fun removeItem(position: Int) {
        categoryAdapter.notifyItemRemoved(position)
    }

    override fun showProductInfo(product: Product) {
        startActivity(Intent(this, ProductInfoActivity::class.java).apply {
            putExtra(ProductInfoActivity.PRODUCT_TAG, product)
        })
    }

    override fun showProductsByCategory(category: Category) {
        startActivity(Intent(this, ProductsActivity::class.java).apply {
            putExtra(ProductsActivity.CATEGORY_TAG, category)
        })
    }


}