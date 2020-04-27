package com.example.pavel_bodrov_shop.presenter

import com.example.pavel_bodrov_shop.domain.ViewedProductDao
import com.example.pavel_bodrov_shop.domain.model.Product
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class CatalogPresenter(
    private val viewedProductDao: ViewedProductDao
): MvpPresenter<CatalogView>() {

    val categories = mutableListOf(
        "Телевизоры",
        "Телефоны",
        "Планшеты",
        "Часы",
        "Дрова"
    )


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setCategories(categories)
    }

    override fun attachView(view: CatalogView?) {
        super.attachView(view)
        val productIds = viewedProductDao.getAllProducts()
        val products = productIds.map{ viewedProductDao.getProductById(it) }
        viewState.setLastViewed(products)
    }

    fun removeItem(category: String) {
        val position = categories.indexOf(category)
        categories.remove(category)
        viewState.removeItem(position)
    }

    fun showProductInfo(product: Product) {
        viewState.showProductInfo(product)
    }
}