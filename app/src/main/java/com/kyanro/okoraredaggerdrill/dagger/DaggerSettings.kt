package com.kyanro.okoraredaggerdrill.dagger

import com.kyanro.okoraredaggerdrill.domain.fortune.FortuneTextCreator
import com.kyanro.okoraredaggerdrill.domain.luckynumber.LuckyNumberTextCreator
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@AppScope
@Component(modules = [LuckyNumberModule::class, FortuneModule::class])
interface AppComponent {
    fun getLuckyNumberTextCreator(): LuckyNumberTextCreator

    fun getFortuneTextCreator(): FortuneTextCreator
}

@Module
class LuckyNumberModule(private val luckyNumber: Int) {
    @AppScope
    @Provides
    fun provideLuckyNumberTextCreator() =
        LuckyNumberTextCreator(luckyNumber)

    @AppScope
    @Provides
    fun provideLuckyNumber() = luckyNumber
}

@Module
class FortuneModule {
    @AppScope
    @Provides
    fun provideFortuneTextCreator(luckyNumber: Int) = FortuneTextCreator(luckyNumber)
}

@Scope
annotation class AppScope
