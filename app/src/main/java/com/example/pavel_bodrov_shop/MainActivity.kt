package com.example.pavel_bodrov_shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ProductView {

    private val productPresenter = ProductsPresenter(this)
    private val cartPresenter = CartPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        productPresenter.pricePrint()
//        cartPresenter.printCart()

        cartDescription.text = cartPresenter.getCartItemsStr()
        cartTotal.text = cartPresenter.getCartTotal()
    }

    override fun print(price: Double) {
        Toast.makeText(this, "Price: $price", Toast.LENGTH_LONG).show()
    }

    override fun print(product: Product) {
        Toast.makeText(this, "Price: ${product.getDiscountPrice()}", Toast.LENGTH_LONG).show()
    }

    // вывод корзины в лог
    override fun print(cart: Cart) {
        val logPrinter: ProductView = LogPrinter()
        logPrinter.print(cart)
    }

    override fun print(name: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
