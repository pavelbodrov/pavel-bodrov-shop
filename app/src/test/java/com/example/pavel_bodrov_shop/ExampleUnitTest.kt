package com.example.pavel_bodrov_shop

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.truncate

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun productPrinterTest() {
        val iphoneCase = Product(price = 123.5, discount = 30)

        val pricePrinter: PricePrinter = TerminalPricePrinter()

        pricePrinter.print(iphoneCase)
    }

    @Test
    fun cartPrinterTest() {
        val iphoneCase = Product(price = 123.5, discount = 30)

        val pricePrinter: PricePrinter = TerminalPricePrinter()
        val testCart = Cart(listOf(
            Product(price = 123.5, discount = 30),
            Product(price = 256.17, discount = 5),
            Product(price = 3967.0, discount = 17))
        )

        pricePrinter.print(testCart)
    }
}
