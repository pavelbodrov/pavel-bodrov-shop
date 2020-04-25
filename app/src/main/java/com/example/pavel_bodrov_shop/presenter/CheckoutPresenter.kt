package com.example.pavel_bodrov_shop.presenter

import com.example.pavel_bodrov_shop.CreateOrderModel
import com.example.pavel_bodrov_shop.OrderView
import com.example.pavel_bodrov_shop.model.Cart
import com.example.pavel_bodrov_shop.model.Product
import moxy.MvpPresenter

class CheckoutPresenter: MvpPresenter<OrderView>() {
    private val cart = Cart(
        mutableListOf(
            Product(
                price = 123.5,
                discount = 30,
                productName = "product 1"
            ),
            Product(
                price = 256.17,
                discount = 5,
                productName = "product 2"
            ),
            Product(
                price = 3967.0,
                discount = 17,
                productName = "product 3"
            )
        )
    )

    private val model = CreateOrderModel()

    fun checkFirstName(text: String) {
        if (isInputValid(text)) {
            model.firstName = text
            viewState.showErrorFirstName(false)
        }
        else viewState.showErrorFirstName(true)
    }

    fun checkLastName(text: String) {
        if (isInputValid(text)) {
            model.lastName = text
            viewState.showErrorLastName(false)
        }
        else {
            viewState.showErrorLastName(true)
        }
    }

    fun checkMiddleName(text: String) {
        if (isInputValid(text)) {
            model.middleName = text
            viewState.showErrorMiddleName(false)
        }
        else {
            viewState.showErrorMiddleName(true)
        }
    }

    fun checkPhoneNumber(text: String) {
        val regex = """(\+7|8)\d{10}""".toRegex()
        if (regex.matches(input = text)) {
            model.phoneNumber = text
            viewState.showErrorPhoneNumber(false)
        }
        else {
            viewState.showErrorPhoneNumber(true)
        }
    }

    private fun isInputValid(text: String): Boolean = text.length > 1

    fun printCart() {
        viewState.print(cart)
    }

    fun getCartItemsStr(): String {
        var resultStr: String = ""
        var productPrice: String
        cart.products.forEach{
            productPrice = "%.2f".format(it.discountPrice)
            resultStr = resultStr.plus("${it.productName} ..... ")
            resultStr = resultStr.plus("$productPrice Р (скидка ${it.discount}%)\n")
        }

        return resultStr
    }

    fun getCartTotal(): String {
        val discountPrice = cart.discountSum
        val fullSum = cart.fullSum
        val discountSum = fullSum - discountPrice

        var resultStr = "Итого без учета скидок: %.2f Р\n".format(fullSum)
        resultStr = resultStr.plus("Сумма скидок: %.2f Р\n".format(discountSum))
        resultStr = resultStr.plus("К оплате: %.2f Р\n".format(discountPrice))

        return resultStr
    }
}