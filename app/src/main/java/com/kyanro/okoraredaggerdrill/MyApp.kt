package com.kyanro.okoraredaggerdrill

import android.app.Application
import android.util.Log
import com.kyanro.okoraredaggerdrill.dagger.AppComponent
import com.kyanro.okoraredaggerdrill.dagger.DaggerAppComponent
import com.kyanro.okoraredaggerdrill.dagger.LuckyNumberModule

open class MyApp : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        createComponent()
    }

    protected open fun createComponent() {
        val luckyNumber = 777
        val luckyNumberModule = LuckyNumberModule(luckyNumber)
        appComponent = DaggerAppComponent.builder()
            .luckyNumberModule(luckyNumberModule)
            .build()

        Log.d("lucky-log", appComponent.getLuckyNumberTextCreator().luckyNumberText())
    }
}