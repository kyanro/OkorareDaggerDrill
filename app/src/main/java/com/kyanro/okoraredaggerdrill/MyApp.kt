package com.kyanro.okoraredaggerdrill

import android.app.Application
import com.kyanro.okoraredaggerdrill.dagger.AppComponent
import com.kyanro.okoraredaggerdrill.dagger.DaggerAppComponent

class MyApp : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}