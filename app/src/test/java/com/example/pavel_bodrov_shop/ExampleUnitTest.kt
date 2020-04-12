package com.example.pavel_bodrov_shop

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val presenter = Presenter()
    @Test
    fun productPrinterTest() {
        val iphoneCase = Product(price = 123.5, discount = 30, productName = "iphonecase")

        val pricePrinter: PricePrinter = ConsolePricePrinter()

        pricePrinter.print(iphoneCase)
    }

    @Test
    fun cartPrinterTest() {
        val pricePrinter: PricePrinter = ConsolePricePrinter()
        val testCart = Cart(listOf(
            Product(price = 123.5, discount = 30, productName = "case1"),
            Product(price = 256.17, discount = 5, productName = "case2"),
            Product(price = 3967.0, discount = 17, productName = "case3"))
        )

        pricePrinter.print(testCart)
    }

    @Test
    fun presenterTest() {
        presenter.productPrint()
    }
}

class Presenter{
    private val iphoneCase = Product(price = 123.5, discount = 30, productName = "phone case")
    private val samsungCase = Product(price = 30.5, discount = 5, productName = "samsung case")

    private val pricePrinter: PricePrinter = ConsolePricePrinter()

    private val products = listOf(iphoneCase, samsungCase)

    fun pricePrint() {
        products.forEach {product -> pricePrinter.print(product) }
    }

    fun productNamePrint() {
        products.forEach {product -> pricePrinter.print(product.getProductName()) }
    }

    fun productPrint() {
        products.forEach { product ->
            pricePrinter.print("${product.getProductName()}: ${product.getDiscountPrice()}")
        }
    }

}