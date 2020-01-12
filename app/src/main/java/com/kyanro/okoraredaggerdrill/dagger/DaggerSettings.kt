package com.kyanro.okoraredaggerdrill.dagger

import com.kyanro.okoraredaggerdrill.domain.luckynumber.LuckyNumberTextCreator
import com.kyanro.okoraredaggerdrill.ui.home.dagger.HomeSecondSubComponent
import com.kyanro.okoraredaggerdrill.ui.home.dagger.HomeSecondSubComponentModule
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@AppScope
@Component(modules = [LuckyNumberModule::class, HomeSecondSubComponentModule::class])
interface AppComponent {
    fun getLuckyNumberTextCreator(): LuckyNumberTextCreator

    fun getHomeSecondSubComponentFactory(): HomeSecondSubComponent.Factory
}

@Module
class LuckyNumberModule(private val luckyNumber: Int) {
    @AppScope
    @Provides
    fun provideLuckyNumber() = luckyNumber
}

@Scope
annotation class AppScope

@Scope
annotation class FragmentScope
