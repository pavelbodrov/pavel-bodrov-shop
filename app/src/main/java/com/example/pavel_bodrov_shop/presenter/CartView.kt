package com.example.pavel_bodrov_shop.presenter

import com.example.pavel_bodrov_shop.domain.model.Product
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface CartView: MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setProducts(list: List<Product>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun removeItem(position: Int)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun addItem(position: Int)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProductInfo(product: Product)
}