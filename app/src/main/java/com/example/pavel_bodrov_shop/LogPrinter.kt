package com.example.pavel_bodrov_shop

import android.util.Log
import com.example.pavel_bodrov_shop.model.Cart
import com.example.pavel_bodrov_shop.model.Product
import kotlin.math.truncate

class LogPrinter: OrderView {

    override fun print(product: Product) {
        val price = product.discountPrice
        val strPrice: String

        strPrice = if (truncate(price) == price) {
            "%.0fP".format(price)
        } else {
            "%.2fP".format(price)

        }
        Log.d("Print", "${product.productName}: $strPrice P")
    }

    override fun showErrorFirstName(visible: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorLastName(visible: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorMiddleName(visible: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorPhoneNumber(visible: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun print(cart: Cart) {
        cart.products.forEach(this::print)
        val totalCartSum = cart.discountSum
        val strPrice: String
        strPrice = if (truncate(totalCartSum) == totalCartSum) {
            "%.0fP".format(totalCartSum)
        } else {
            "%.2fP".format(totalCartSum)
        }
        Log.d("Print","Сумма покупок с учетом скидок: $strPrice")
    }

    override fun print(string: String) {
        Log.d("Print", string)
    }
}