package com.example.pavel_bodrov_shop.model

class Cart (var products: MutableList<Product> = mutableListOf()) {
    val discountSum get() = products.map {product -> product.discountPrice}.sum()
    val fullSum get() = products.map {product -> product.price}.sum()
}