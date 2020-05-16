package com.example.pavel_bodrov_shop.presenter.view

import com.example.pavel_bodrov_shop.domain.model.Cart
import com.example.pavel_bodrov_shop.domain.model.Product
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface CheckoutView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun print(string: String)

    fun showErrorFirstName(visible: Boolean)
    fun showErrorLastName(visible: Boolean)
    fun showErrorMiddleName(visible: Boolean)
    fun showErrorPhoneNumber(visible: Boolean)

    fun print(cart: Cart)
    fun print(product: Product)
}