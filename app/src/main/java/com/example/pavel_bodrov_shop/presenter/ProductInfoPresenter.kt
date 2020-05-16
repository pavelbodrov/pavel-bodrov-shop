package com.example.pavel_bodrov_shop.presenter

import com.example.pavel_bodrov_shop.domain.CartProductsDao
import com.example.pavel_bodrov_shop.domain.ViewedProductDao
import com.example.pavel_bodrov_shop.domain.model.Product
import com.example.pavel_bodrov_shop.presenter.view.ProductInfoView
import moxy.MvpPresenter
import javax.inject.Inject

class ProductInfoPresenter @Inject constructor(
    private val viewedProductDao: ViewedProductDao,
    private val cartProductsDao: CartProductsDao
): MvpPresenter<ProductInfoView>()  {
    fun onProductShow(product: Product) {
        viewedProductDao.addProduct(product.id)
    }

    fun onAddToCartClick(product: Product) {
        cartProductsDao.addToCart(product.id)
    }
}