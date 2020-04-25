package com.example.pavel_bodrov_shop.presenter

import moxy.MvpPresenter

class CatalogPresenter: MvpPresenter<CatalogView>() {

    val list = mutableListOf(
        "Телевизоры",
        "Телефоны",
        "Планшеты",
        "Часы"
    )

    fun setData() {
        viewState.setCategories(list)
    }

    fun removeItem(category: String) {
        val position = list.indexOf(category)
        list.remove(category)
        viewState.removeItem(position)
    }
}