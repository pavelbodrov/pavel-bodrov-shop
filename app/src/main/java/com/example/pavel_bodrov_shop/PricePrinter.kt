package com.example.pavel_bodrov_shop

import com.example.pavel_bodrov_shop.model.Cart
import com.example.pavel_bodrov_shop.model.Product


interface PricePrinter {
    /**
     * Outputs price in <PRICE>P format.
     * If price have not fractional part than it will be printed as integer
     * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    fun print(product: Product)
    fun print(cart: Cart)
    fun print(name: String)
}