package com.example.pavel_bodrov_shop.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Product(
    /**
     * Must be positive
     */
    val id: Long,
    val name: String,
    val price: Double,
    val discount: Int,
    val description: String,
    val imageUrl: String
): Parcelable {
    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 than product will have negative price
     * If [salePercent] less than 0 product price will be increased
     */

    val discountPrice get() = price * (1 - discount / 100.0)
}