package com.example.pavel_bodrov_shop.data

import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import com.example.pavel_bodrov_shop.domain.CartProductsDao
import com.example.pavel_bodrov_shop.domain.model.Product

class CartProductsDaoImpl(
    private val sharedPreferences: SharedPreferences
): CartProductsDao {

    private var cartProductsIds: List<Long>
        get() = sharedPreferences.getString(CART_TAG, null)
            ?.split(",")
            ?.mapNotNull { it.toLongOrNull() } ?: emptyList()
        set(value) = sharedPreferences.edit {
            putString(CART_TAG, value.joinToString(","))
        }

    override fun addToCart(productId: Long) {
        val productIds:List<Long> = cartProductsIds
        val newProductIds: MutableList<Long> = mutableListOf<Long>().apply {
            addAll(productIds)
            add(productId)
        }

        cartProductsIds = newProductIds
    }

    override fun removeFromCart(productId: Long) {
        val productIds:List<Long> = cartProductsIds
        val newProductIds: MutableList<Long> = mutableListOf<Long>().apply {
            addAll(productIds.filter { it != productId})
        }

        cartProductsIds = newProductIds
    }

    override fun getAllProducts(): List<Long> {
        return cartProductsIds
    }

    companion object {
        private const val CART_TAG = "CART_TAG"
    }
}