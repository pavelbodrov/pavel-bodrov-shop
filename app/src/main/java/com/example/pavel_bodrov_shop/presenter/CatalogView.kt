package com.example.pavel_bodrov_shop.presenter

import com.example.pavel_bodrov_shop.domain.model.Category
import com.example.pavel_bodrov_shop.domain.model.Product
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface CatalogView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setCategories(list: List<Category>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setLastViewed(products: List<Product>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun removeItem(position: Int)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showProductIds(productIds: List<Long>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProductInfo(product: Product)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProductsByCategory(category: Category)
}