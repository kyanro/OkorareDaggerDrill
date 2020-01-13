package com.kyanro.okoraredaggerdrill.dagger

import com.kyanro.okoraredaggerdrill.domain.greeting.Greeter
import com.kyanro.okoraredaggerdrill.domain.luckynumber.LuckyNumberTextCreator
import com.kyanro.okoraredaggerdrill.ui.home.dagger.HomeSecondSubComponent
import com.kyanro.okoraredaggerdrill.ui.home.dagger.HomeSecondSubComponentModule
import dagger.Component
import dagger.Module
import dagger.Provides
import java.time.LocalTime
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

@Module
class FragmentLocalTimeModule(private val fragmentLocalTime: LocalTime) {
    @FragmentScope
    @Provides
    fun provideFragmentLocalTime() = fragmentLocalTime
}

@Module
class GreetingModule(private val greetingType: Greeter.GreetingType) {
    @FragmentScope
    @Provides
    fun provideGreeter(fragmentLocalTime: LocalTime) = Greeter(fragmentLocalTime, greetingType)
}

@Scope
annotation class AppScope

@Scope
annotation class FragmentScope
