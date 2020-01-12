package com.kyanro.okoraredaggerdrill.domain.fortune

import com.kyanro.okoraredaggerdrill.dagger.AppScope
import com.kyanro.okoraredaggerdrill.dagger.FragmentScope
import javax.inject.Inject

@FragmentScope
class FortuneTextCreator @Inject constructor(private val luckyNumber: Int) {
    fun fortuneText(tensionBoostEnabled: Boolean): String {
        val fortune = if (tensionBoostEnabled) {
            when (luckyNumber) {
                in 0..499 -> "アゲアゲ！！！"
                in 500..899 -> "アゲ！！"
                else -> "アゲ！"
            }
        } else {
            when (luckyNumber) {
                in 0..99 -> "アゲアゲ！！！"
                in 100..499 -> "アゲ！！"
                in 500..899 -> "サゲ！"
                else -> "サゲサゲ"
            }
        }
        return "今日の運勢: $fortune"
    }
}
