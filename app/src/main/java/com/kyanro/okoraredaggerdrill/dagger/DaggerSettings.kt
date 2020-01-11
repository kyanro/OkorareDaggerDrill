package com.kyanro.okoraredaggerdrill.dagger

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Scope

@AppScope
@Component(modules = [LuckyNumberModule::class, FortuneModule::class])
interface AppComponent {
    @Named("lucky number text")
    fun getLuckyNumberText(): String

    @Named("fortune text")
    fun getFortuneText(): String
}

@Module
class LuckyNumberModule(private val luckyNumber: Int) {
    @AppScope
    @Provides
    @Named("lucky number text")
    fun provideLuckyNumberText() =
        "今日のラッキーナンバー: $luckyNumber"
}

@Module
class FortuneModule(private val luckyNumber: Int) {
    @AppScope
    @Provides
    @Named("fortune text")
    fun provideFortuneText(): String {
        val fortune = when (luckyNumber) {
            in 0..99 -> "アゲアゲ！！！"
            in 100..499 -> "アゲ！！"
            in 500..899 -> "サゲ！"
            else -> "サゲサゲ"
        }
        return "今日の運勢: $fortune"
    }
}

@Scope
annotation class AppScope
