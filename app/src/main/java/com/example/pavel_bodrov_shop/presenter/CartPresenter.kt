package com.example.pavel_bodrov_shop.presenter

import com.example.pavel_bodrov_shop.domain.model.Cart
import com.example.pavel_bodrov_shop.domain.model.Product
import moxy.MvpPresenter

class CartPresenter: MvpPresenter<CartView>() {
    private val cart = Cart(mutableListOf(
            Product(
                id = 1,
                price = 123.5,
                discount = 30,
                productName = "product 1"
            ),
            Product(
                id = 2,
                price = 256.17,
                discount = 5,
                productName = "product 2"
            ),
            Product(
                id = 3,
                price = 3967.0,
                discount = 17,
                productName = "product 3"
            )
        )
    )

    private val productToAdd = Product(id = 4, price = 12.3, discount = 5, productName = "New product")

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

    fun showProductInfo(product: Product) {
        viewState.showProductInfo(product)
    }
}