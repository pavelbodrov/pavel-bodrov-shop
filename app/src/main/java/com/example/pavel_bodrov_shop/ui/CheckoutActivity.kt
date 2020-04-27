package com.example.pavel_bodrov_shop.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import com.example.pavel_bodrov_shop.*
import com.example.pavel_bodrov_shop.domain.model.Cart
import com.example.pavel_bodrov_shop.domain.model.Product
import com.example.pavel_bodrov_shop.presenter.CheckoutPresenter
import com.example.pavel_bodrov_shop.presenter.CheckoutView
import kotlinx.android.synthetic.main.checkout_layout.*

class CheckoutActivity : BaseActivity(),
    CheckoutView {

    private val presenter = CheckoutPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkout_layout)

//        productPresenter.pricePrint()
//        cartPresenter.printCart()

        presenter.attachView(this)

        cartDescription.text = presenter.getCartItemsStr()
        cartTotal.text = presenter.getCartTotal()

        setListeners()
    }

    private fun setListeners() {
        firstNameInput.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.checkFirstName(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        lastNameInput.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.checkLastName(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        middleNameInput.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.checkMiddleName(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        phoneInput.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.checkPhoneNumber(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        checkoutBackButton.setOnClickListener { finish() }

    }

    override fun print(product: Product) {
        Toast.makeText(this, "Price: ${product.discountPrice}", Toast.LENGTH_LONG).show()
    }

    override fun showErrorFirstName(visible: Boolean) {
        firstNameInput.showError(visible)
    }

    override fun showErrorLastName(visible: Boolean) {
        lastNameInput.showError(visible)
    }

    override fun showErrorMiddleName(visible: Boolean) {
        middleNameInput.showError(visible)
    }

    override fun showErrorPhoneNumber(visible: Boolean) {
        phoneInput.showError(visible)
    }

    // вывод корзины в лог
    override fun print(cart: Cart) {
        val logPrinter: CheckoutView =
            LogPrinter()
        logPrinter.print(cart)
    }

    override fun print(string: String) {
    }

    fun EditText.showError(visible: Boolean) {
        val drawable = if (visible) R.drawable.ic_error else 0

        this.setCompoundDrawablesWithIntrinsicBounds(0,0, drawable,0)
    }
}
