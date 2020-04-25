package com.example.pavel_bodrov_shop.model

class Product(
    /**
     * Must be positive
     */
    val price: Double,
    val discount: Int = 0,
    val productName: String
) {
    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 than product will have negative price
     * If [salePercent] less than 0 product price will be increased
     */

    val discountPrice get() = price * (1 - discount / 100.0)
}