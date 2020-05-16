package com.example.pavel_bodrov_shop.presenter

import com.example.pavel_bodrov_shop.domain.MainApi
import com.example.pavel_bodrov_shop.domain.model.Category
import com.example.pavel_bodrov_shop.domain.model.Product
import kotlinx.coroutines.launch
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class ProductsPresenter @Inject constructor(private val mainApi: MainApi): BasePresenter<ProductsView>() {
    fun setProducts(category: Category) {
        launch {
            viewState.setProducts(mainApi.productsByCategory(category.id))
        }
    }

    fun showProductInfo(product: Product) {
        viewState.showProductInfo(product)
    }
}