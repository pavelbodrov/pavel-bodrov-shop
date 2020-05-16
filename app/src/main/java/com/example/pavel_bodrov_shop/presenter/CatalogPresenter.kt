package com.example.pavel_bodrov_shop.presenter
import com.example.pavel_bodrov_shop.domain.MainApi
import com.example.pavel_bodrov_shop.domain.ViewedProductDao
import com.example.pavel_bodrov_shop.domain.model.Category
import com.example.pavel_bodrov_shop.domain.model.Product
import com.example.pavel_bodrov_shop.presenter.view.CatalogView
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class CatalogPresenter @Inject constructor(
    private val mainApi: MainApi,
    private val viewedProductDao: ViewedProductDao
): BasePresenter<CatalogView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        launch {
            viewState.setCategories(mainApi.allCategoriesNames())
        }
    }

    override fun attachView(view: CatalogView?) {
        super.attachView(view)
        val productIds = viewedProductDao.getAllProducts()
        val products = listOf<Product>().toMutableList()
        productIds.forEach {
            runBlocking {
                val product = mainApi.productById(it)
                products.add(product)
            }
        }
        viewState.setLastViewed(products)
    }

    fun showProductInfo(product: Product) {
        viewState.showProductInfo(product)
    }

    fun showProductsByCategory(category: Category) {
        viewState.showProductsByCategory(category)
    }
}