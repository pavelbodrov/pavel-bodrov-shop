package com.example.pavel_bodrov_shop

interface ProductView {
    fun print(price: Double)
    fun print(product: Product)
    fun print(cart: Cart)
    fun print(name: String)
}