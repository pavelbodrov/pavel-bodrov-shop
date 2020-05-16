package com.example.pavel_bodrov_shop.domain

import com.example.pavel_bodrov_shop.domain.model.Product

interface CartProductsDao {
    fun addToCart(productId: Long)

    fun removeFromCart(productId: Long)

    fun getAllProducts():List<Long>
}