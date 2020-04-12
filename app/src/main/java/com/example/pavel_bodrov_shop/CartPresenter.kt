package com.example.pavel_bodrov_shop

import kotlin.math.truncate

class CartPresenter (private val view: ProductView) {
    private val cart = Cart(listOf(
        Product(price = 123.5, discount = 30, productName = "product 1"),
        Product(price = 256.17, discount = 5, productName = "product 2"),
        Product(price = 3967.0, discount = 17, productName = "product 3"))
    )

    fun printCart() {
        view.print(cart)
    }

    fun getCartItemsStr(): String {
        var resultStr: String = ""
        var productPrice: String
        cart.products.forEach{
            productPrice = "%.2f".format(it.getDiscountPrice())
            resultStr = resultStr.plus("${it.getProductName()} ..... ")
            resultStr = resultStr.plus("$productPrice Р (скидка ${it.getDiscount()}%)\n")
        }

        return resultStr
    }

    fun getCartTotal(): String {
        val discountPrice = cart.getDiscountSum()
        val fullSum = cart.getFullSum()
        val discountSum = fullSum - discountPrice

        var resultStr = "Итого без учета скидок: %.2f Р\n".format(fullSum)
        resultStr = resultStr.plus("Сумма скидок: %.2f Р\n".format(discountSum))
        resultStr = resultStr.plus("К оплате: %.2f Р\n".format(discountPrice))

        return resultStr
    }
}