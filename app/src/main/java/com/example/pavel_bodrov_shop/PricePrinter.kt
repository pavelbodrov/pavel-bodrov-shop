package com.example.pavel_bodrov_shop

interface PricePrinter {
    /**
     * Outputs price in <PRICE>P format.
     * If price have not fractional part than it will be printed as integer
     * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    fun print(product: Product)
    fun print(cart: Cart)
}