package com.example.pavel_bodrov_shop

class ProductsPresenter(
    private val view: ProductView
) {
    private val iphoneCase = Product(price = 123.5, discount = 30, productName = "case 1")
    private val samsungCase = Product(price = 30.5, discount = 5, productName = "case 2")

    private val products = listOf(iphoneCase, samsungCase)

    fun pricePrint() {
        view.print(iphoneCase.getDiscountPrice())
//        products.forEach {product -> view.print(product) }
    }

    fun productNamePrint() {
        products.forEach {product -> view.print(product.getProductName()) }
    }

    fun productPrint() {
        products.forEach { product ->
            view.print("${product.getProductName()}: ${product.getDiscountPrice()}")
        }
    }
}