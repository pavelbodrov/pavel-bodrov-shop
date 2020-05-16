package com.example.pavel_bodrov_shop.domain

import com.example.pavel_bodrov_shop.domain.model.Product

interface ViewedProductDao {
    fun addProduct(productId: Long)

    fun getAllProducts():List<Long>
}