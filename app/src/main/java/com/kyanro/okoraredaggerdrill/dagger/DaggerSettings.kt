package com.kyanro.okoraredaggerdrill.dagger

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Scope
import kotlin.random.Random

@AppScope
@Component(modules = [LuckyNumberModule::class])
interface AppComponent {
    @Named("lucky number text")
    fun getLuckyNumberText(): String
}

@Module
class LuckyNumberModule {
    @AppScope
    @Provides
    @Named("lucky number text")
    fun provideLuckyNumberText() =
        "今日のラッキーナンバー: ${Random.nextInt(1, 1000)}"
}

@Scope
annotation class AppScope
