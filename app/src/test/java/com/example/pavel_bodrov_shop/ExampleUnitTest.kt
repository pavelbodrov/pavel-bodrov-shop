package com.example.pavel_bodrov_shop

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    fun formatPrice(price: Double, units: String = "Шт.", discount: Int): String {
        val result: String

        if (discount > 0) {
            result = "${price - price * discount / 100}/$units (скидка $discount%)"
        }
        else {
            result = "$price/$units"
        }
        return result
    }


    @Test
    fun runTest() {
        print(formatPrice(price = 274.0, discount = 5))
    }
}
