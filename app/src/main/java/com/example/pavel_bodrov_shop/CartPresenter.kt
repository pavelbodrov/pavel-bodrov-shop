package com.example.pavel_bodrov_shop

class CartPresenter (private val view: ProductView) {
    private val cart = Cart(listOf(
        Product(price = 123.5, discount = 30, productName = "product 1"),
        Product(price = 256.17, discount = 5, productName = "product 2"),
        Product(price = 3967.0, discount = 17, productName = "product 3"))
    )

    fun printCart() {
        view.print(cart)
    }
}