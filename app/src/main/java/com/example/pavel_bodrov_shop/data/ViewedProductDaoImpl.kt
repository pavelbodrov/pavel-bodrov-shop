package com.example.pavel_bodrov_shop.data

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.pavel_bodrov_shop.domain.ViewedProductDao
import com.example.pavel_bodrov_shop.domain.model.Product

class ViewedProductDaoImpl(
    private val sharedPreferences: SharedPreferences
): ViewedProductDao {

    private var savedProductIds: List<Long>
        get() = sharedPreferences.getString(PRODUCT_TAG, null)
            ?.split(",")
            ?.mapNotNull { it.toLongOrNull() } ?: emptyList()
        set(value) = sharedPreferences.edit {
            putString(PRODUCT_TAG, value.joinToString(","))
        }

    override fun addProduct(productId: Long) {
        val productIds:List<Long> = savedProductIds
        val newProductIds: MutableList<Long> = mutableListOf<Long>().apply {
            add(productId)
            addAll(productIds.filter { it != productId})
        }

        savedProductIds = newProductIds
    }

    override fun getAllProducts(): List<Long> {
        return savedProductIds
    }

    override fun getProductById(productId: Long): Product {
        val products = listOf<Product>(
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
            ),
            Product(
                id = 4,
                price = 3967.0,
                discount = 17,
                productName = "product 4"
            )
        )

        return products.find{ it.id == productId } ?: products[0]
    }


    companion object {
        private const val PRODUCT_TAG = "PRODUCT_TAG"
    }
}