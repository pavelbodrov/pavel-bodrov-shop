package com.example.pavel_bodrov_shop.domain

import com.example.pavel_bodrov_shop.domain.model.Category
import com.example.pavel_bodrov_shop.domain.model.Product
import retrofit2.http.GET
import retrofit2.http.Path

interface MainApi {

    @GET("catalog/categories")
    suspend fun allCategoriesNames(): List<Category>

    @GET("catalog/categoriesWithProducts")
    suspend fun categoriesWithProducts(): List<Category>

    @GET("catalog/{category_id}/products")
    suspend fun productsByCategory(@Path("category_id") category_id: String): List<Product>

    @GET("catalog/products/{product_id}")
    suspend fun productById(@Path("product_id") product_id: Long): Product

}