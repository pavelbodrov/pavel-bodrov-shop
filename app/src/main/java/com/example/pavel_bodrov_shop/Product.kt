package com.example.pavel_bodrov_shop

class Product(
    /**
     * Must be positive
     */
    private val price: Double,
    private val discount: Int = 0,
    private val productName: String
) {
    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 than product will have negative price
     * If [salePercent] less than 0 product price will be increased
     */
    fun calcDiscountPrice(): Double = price * (1 - discount / 100.0)

    fun getProductName(): String = productName
}