package com.example.pavel_bodrov_shop

import kotlin.math.truncate

class TerminalPricePrinter: PricePrinter {
    override fun print(product: Product) {
        val price = product.calcDiscountPrice()
        if (truncate(price) == price) {
            println("%.0fP".format(price))
        }
        else {
            println("%.2fP".format(price))
        }
    }

    override fun print(cart: Cart) {
        cart.products.forEach(this::print)
        val totalCartSum = cart.calcTotal()
        val strPrice: String
        strPrice = if (truncate(totalCartSum) == totalCartSum) {
            "%.0fP".format(totalCartSum)
        } else {
            "%.2fP".format(totalCartSum)
        }
        println("Сумма покупок с учетом скидок: $strPrice")
    }
}