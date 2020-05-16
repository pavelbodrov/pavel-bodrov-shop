package com.example.pavel_bodrov_shop.presenter

import com.example.pavel_bodrov_shop.domain.model.Product
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface ProductsView: MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setDummy(products: List<Product>)
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setProducts(products: List<Product>)
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProductInfo(product: Product)
}