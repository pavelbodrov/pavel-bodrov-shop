package com.example.pavel_bodrov_shop.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.example.pavel_bodrov_shop.data.CartProductsDaoImpl
import com.example.pavel_bodrov_shop.data.ViewedProductDaoImpl
import com.example.pavel_bodrov_shop.domain.CartProductsDao
import com.example.pavel_bodrov_shop.domain.ViewedProductDao
import dagger.Module
import dagger.Provides

@Module
class PreferencesModule {
    @Provides
    fun providePreferences(context: Context): SharedPreferences =
        context.getSharedPreferences("data", Context.MODE_PRIVATE)

    @Provides
    fun provideViewedProduct(preferences: SharedPreferences): ViewedProductDao =
        ViewedProductDaoImpl(preferences)

    @Provides
    fun provideCartProduct(preferences: SharedPreferences): CartProductsDao =
        CartProductsDaoImpl(preferences)
}