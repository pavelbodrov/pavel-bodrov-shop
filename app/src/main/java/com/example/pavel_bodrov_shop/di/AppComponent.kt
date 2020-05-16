package com.example.pavel_bodrov_shop.di

import android.content.Context
import com.example.pavel_bodrov_shop.di.modules.MainApiModule
import com.example.pavel_bodrov_shop.di.modules.PreferencesModule
import com.example.pavel_bodrov_shop.ui.CartActivity
import com.example.pavel_bodrov_shop.ui.CatalogActivity
import com.example.pavel_bodrov_shop.ui.ProductInfoActivity
import com.example.pavel_bodrov_shop.ui.ProductsActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        PreferencesModule::class,
        MainApiModule::class
    ]
)
@Singleton
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }

    fun inject(activity: CatalogActivity)
    fun inject(activity: ProductInfoActivity)
    fun inject(activity: ProductsActivity)
    fun inject(activity: CartActivity)
}