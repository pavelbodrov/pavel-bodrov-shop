package com.example.pavel_bodrov_shop

class Cart (val products: List<Product> = emptyList()) {
    fun calcTotal() = products.map {product -> product.calcDiscountPrice()}.sum()
}