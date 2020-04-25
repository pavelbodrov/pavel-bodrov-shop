package com.example.pavel_bodrov_shop.presenter

import com.example.pavel_bodrov_shop.model.Cart
import com.example.pavel_bodrov_shop.model.Product
import moxy.MvpPresenter

class CartPresenter: MvpPresenter<CartView>() {
    private val cart = Cart(mutableListOf(
            Product(
                price = 123.5,
                discount = 30,
                productName = "product 1"
            ),
            Product(
                price = 256.17,
                discount = 5,
                productName = "product 2"
            ),
            Product(
                price = 3967.0,
                discount = 17,
                productName = "product 3"
            )
        )
    )

    private val productToAdd = Product(price = 12.3, discount = 5, productName = "New product")

    fun setData() {
        viewState.setProducts(cart.products)
    }

    fun removeItem(productName: String) {
        val position = cart.products.indexOf(
            cart.products.find { product -> product.productName == productName }
        )
        cart.products.removeAt(position)
        viewState.removeItem(position)
    }

    fun addItem() {
        val position = cart.products.size
        cart.products.add(position, productToAdd)
        viewState.addItem(position)
    }
}