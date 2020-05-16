package com.example.pavel_bodrov_shop.presenter

import android.util.Log
import com.example.pavel_bodrov_shop.domain.CartProductsDao
import com.example.pavel_bodrov_shop.domain.MainApi
import com.example.pavel_bodrov_shop.domain.model.Product
import kotlinx.coroutines.launch
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class CartPresenter@Inject constructor(
    private val mainApi: MainApi,
    private val cartProductsDao: CartProductsDao
): BasePresenter<CartView>() {
    private val productIds = cartProductsDao.getAllProducts()
//    private var products = productIds.map{ cartProductsDao.getProductById(it) }.toMutableList()
//    private var products = listOf<Product>().toMutableList()
    private val products = java.util.Collections.synchronizedList(mutableListOf<Product>())

    private fun setProductsList() {
        productIds.forEach {
            Log.d("DUMMY", it.toString())
            launch {
                val product = mainApi.productById(it)
                Log.d("DUMMY", product.name)
                products += product
            }
        }
    }

    fun setData() {
        setProductsList()
        Log.d("DUMMY_SIZE", products.size.toString())
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