package com.example.pavel_bodrov_shop.presenter

import com.example.pavel_bodrov_shop.domain.ViewedProductDao
import com.example.pavel_bodrov_shop.domain.model.Product
import moxy.MvpPresenter

class ProductInfoPresenter(private val viewedProductDao: ViewedProductDao): MvpPresenter<ProductInfoView>()  {
    fun onProductShow(product: Product) {
        viewedProductDao.addProduct(product.id)
    }
}