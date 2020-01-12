package com.kyanro.okoraredaggerdrill.domain.fortune

import com.kyanro.okoraredaggerdrill.dagger.AppScope
import javax.inject.Inject

@AppScope
class FortuneTextCreator @Inject constructor(private val luckyNumber: Int) {
    fun fortuneText(): String {
        val fortune = when (luckyNumber) {
            in 0..99 -> "アゲアゲ！！！"
            in 100..499 -> "アゲ！！"
            in 500..899 -> "サゲ！"
            else -> "サゲサゲ"
        }
        return "今日の運勢: $fortune"
    }
}