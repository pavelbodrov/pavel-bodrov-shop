package com.example.pavel_bodrov_shop.presenter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import moxy.MvpPresenter
import moxy.MvpView
import kotlin.coroutines.CoroutineContext

abstract class BasePresenter<TView: MvpView>: MvpPresenter<TView>(), CoroutineScope {
    private val job = SupervisorJob()

    override val coroutineContext: CoroutineContext = Dispatchers.Main + job
    private val scope = CoroutineScope(Dispatchers.Main + job)


    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}