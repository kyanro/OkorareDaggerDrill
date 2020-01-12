package com.kyanro.okoraredaggerdrill.dagger

import com.kyanro.okoraredaggerdrill.domain.fortune.FortuneTextCreator
import com.kyanro.okoraredaggerdrill.domain.luckynumber.LuckyNumberTextCreator
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@AppScope
@Component(modules = [LuckyNumberModule::class])
interface AppComponent {
    fun getLuckyNumberTextCreator(): LuckyNumberTextCreator

    fun getFortuneTextCreator(): FortuneTextCreator
}

@Module
class LuckyNumberModule(private val luckyNumber: Int) {
    @AppScope
    @Provides
    fun provideLuckyNumber() = luckyNumber
}

@Scope
annotation class AppScope
