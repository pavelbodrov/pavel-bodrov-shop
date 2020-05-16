package com.example.pavel_bodrov_shop.presenter

import com.example.pavel_bodrov_shop.domain.CartProductsDao
import com.example.pavel_bodrov_shop.domain.MainApi
import com.example.pavel_bodrov_shop.domain.model.Product
import com.example.pavel_bodrov_shop.presenter.view.CartView
import kotlinx.coroutines.runBlocking
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class CartPresenter@Inject constructor(
    private val mainApi: MainApi,
    private val cartProductsDao: CartProductsDao
): BasePresenter<CartView>() {
    private val productIds = cartProductsDao.getAllProducts()
    private val products = java.util.Collections.synchronizedList(mutableListOf<Product>())

    private fun setProductsList() {
        productIds.forEach {
            runBlocking {
                val product = mainApi.productById(it)
                products.add(product)
            }
        }
    }

    fun setData() {
        setProductsList()
        viewState.setProducts(products)
    }

    fun removeItem(product: Product) {
        val position = products.indexOf(
            products.find { it -> it.name == product.name }
        )
        products.removeAt(position)
        cartProductsDao.removeFromCart(product.id)
        val total = products.map {it.price}.sum()
        viewState.removeItem(position, total)
    }

    fun showProductInfo(product: Product) {
        viewState.showProductInfo(product)
    }
}