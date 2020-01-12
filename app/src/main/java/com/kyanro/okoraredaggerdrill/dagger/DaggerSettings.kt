package com.kyanro.okoraredaggerdrill.dagger

import com.kyanro.okoraredaggerdrill.domain.luckynumber.LuckyNumberTextCreator
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Scope

@AppScope
@Component(modules = [LuckyNumberModule::class, FortuneModule::class])
interface AppComponent {
    fun getLuckyNumberTextCreator(): LuckyNumberTextCreator

    @NamedFortuneText
    fun getFortuneText(): String
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
    @NamedFortuneText
    fun provideFortuneText(luckyNumber: Int): String {
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

@Qualifier
annotation class NamedFortuneText
