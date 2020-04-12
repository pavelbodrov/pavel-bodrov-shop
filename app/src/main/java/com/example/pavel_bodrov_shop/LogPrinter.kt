package com.example.pavel_bodrov_shop

import android.util.Log
import kotlin.math.truncate

class LogPrinter: ProductView {
    override fun print(price: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun print(product: Product) {
        val price = product.getDiscountPrice()
        val strPrice: String

        strPrice = if (truncate(price) == price) {
            "%.0fP".format(price)
        } else {
            "%.2fP".format(price)

        }
        Log.d("Print", "${product.getProductName()}: $strPrice P")
    }

    override fun print(cart: Cart) {
        cart.products.forEach(this::print)
        val totalCartSum = cart.getDiscountSum()
        val strPrice: String
        strPrice = if (truncate(totalCartSum) == totalCartSum) {
            "%.0fP".format(totalCartSum)
        } else {
            "%.2fP".format(totalCartSum)
        }
        Log.d("Print","Сумма покупок с учетом скидок: $strPrice")
    }

    override fun print(name: String) {
        Log.d("Print", name)
    }
}