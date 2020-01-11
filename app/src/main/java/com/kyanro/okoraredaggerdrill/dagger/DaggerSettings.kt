package com.kyanro.okoraredaggerdrill.dagger

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Scope

@AppScope
@Component(modules = [LuckyNumberModule::class])
interface AppComponent {
    @Named("lucky number text")
    fun getLuckyNumberText(): String
}

@Module
class LuckyNumberModule(private val luckyNumber: Int) {
    @AppScope
    @Provides
    @Named("lucky number text")
    fun provideLuckyNumberText() =
        "今日のラッキーナンバー: $luckyNumber"
}

@Scope
annotation class AppScope
