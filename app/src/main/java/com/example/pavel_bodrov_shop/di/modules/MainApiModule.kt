package com.example.pavel_bodrov_shop.di.modules

import com.example.pavel_bodrov_shop.domain.MainApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class MainApiModule {

    @Provides
    @Singleton
    fun provideMainApi(): MainApi = Retrofit.Builder()
            .baseUrl("http://192.168.0.100:9191")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MainApi::class.java)
}