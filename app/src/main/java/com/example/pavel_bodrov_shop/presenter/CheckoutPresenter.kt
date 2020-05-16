package com.example.pavel_bodrov_shop.presenter

import com.example.pavel_bodrov_shop.domain.model.CreateOrderModel
import moxy.MvpPresenter

class CheckoutPresenter: MvpPresenter<CheckoutView>() {
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
}