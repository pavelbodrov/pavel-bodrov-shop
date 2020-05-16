package com.example.pavel_bodrov_shop

import com.example.pavel_bodrov_shop.domain.model.Product
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun presenterTest() {
        val categoriesWithProductsMap = mapOf(
            "sport" to listOf(
                Product(
                    id = 1,
                    name = "Honda CBR 1000RR",
                    price = 660000.0,
                    discount = 0,
                    description = "2014 год выпуска. В идеале, без царапин и повреждений, ничего не подтекает и не дымит. Спортивный глушитель, Без ржавчины, Электронное зажигание, Жидкостное охлаждение ",
                    imageUrl = "https://img.drivemag.net/media/default/0002/01/2020-Honda-CBR1000RR-R-SP-05-4680-default-large.jpeg"
                ),
                Product(
                    id = 2,
                    name = "Kawasaki Ninja 1000",
                    price = 350000.0,
                    discount = 0,
                    description = "2011 год выпуска. Жидкостное охлаждение, Электронное зажигание, Спортивный глушитель.",
                    imageUrl = "https://imgd.aeplcdn.com/1200x900/bw/models/kawasaki-ninja-650-2020-standard20191014185335.jpg"
                ),
                Product(
                    id = 3,
                    name = "Ducati X Diavel S",
                    price = 1150000.0,
                    discount = 0,
                    description = "2018 год выпуска. Отличное техническое состояние, родной пробег",
                    imageUrl = "https://cdn1.cycletrader.com/v1/media/5e9ee789400bcd052379baf2.jpg?width=1024&height=768&quality=70&bestfit=true&upsize=true&blurBackground=true&blurValue=100"
                )
            ),
            "street" to listOf(
                Product(
                    id = 4,
                    name = "Triumph Speed Triple R",
                    price = 1219894.0,
                    discount = 0,
                    description = "2015 год выпуска. Множество тюнинга, выхлоп ARROW полная трасса. Пробег 6400 миль",
                    imageUrl = "https://cdp.azureedge.net/products-private/prod/35565399-784a-4957-a484-55528e8ed8a8/73a5f947-f8ba-4de9-9a44-a6100153af43/00000000-0000-0000-0000-000000000000/228f21b3-d50e-409e-919d-a70701511649/d182ecb6-5916-4df6-8d0a-aa1f00feceac/6000000001.jpg"
                ),
                Product(
                    id = 5,
                    name = "Ducati Monster",
                    price = 670000.0,
                    discount = 0,
                    description = "2017 год выпуска. Отличное техническое состояние, родной пробег.",
                    imageUrl = "https://lh3.googleusercontent.com/proxy/89G-lsAqisLMwrWezNyI18KSXdzMl4-Ea5ownR8xqononsZ6irmugXAHdVueAsjxDKBn_8gYtsxsSZYSdqc3RQSreCwspFPIOHrxnYM--2pppEnQFXLN94fMIWh8Sqyjul50-ZR_PYSvGzZLv1DR7I9StP2c4xeqiFhjYASjOXYhmX8xX7rlImGVjD7YPlHdyT70sm65rA2ev3QaWQmKf5zxNfBH6L6tN9xDslw22W59"
                )
            )
        )
//        val product = categoriesWithProductsMap.forEach { (_, products) ->
//            products.find{ it.id == Long(2) }
//        }
        val allProducts = listOf<Product>().toMutableList()

        categoriesWithProductsMap.forEach { (_, products) ->
            allProducts.addAll(products)
        }
        println(allProducts.find{ it.id == 2.toLong() })
    }
}