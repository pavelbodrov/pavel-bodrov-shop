package com.example.pavel_bodrov_shop

import com.example.pavel_bodrov_shop.model.Product
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun productPrinterTest() {
        val iphoneCase = Product(price = 123.5, discount = 30, productName = "iphonecase")

        val pricePrinter: PricePrinter = ConsolePricePrinter()

        pricePrinter.print(iphoneCase)
    }

    @Test
    fun cartPrinterTest() {

    }

    @Test
    fun presenterTest() {
        val products = mutableListOf(
            Product(
                price = 123.5,
                discount = 30,
                productName = "product 1"
            ),
            Product(
                price = 256.17,
                discount = 5,
                productName = "product 2"
            ),
            Product(
                price = 3967.0,
                discount = 17,
                productName = "product 3"
            )
        )

    }
}