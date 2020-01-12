package com.kyanro.okoraredaggerdrill.domain.fortune

class FortuneTextCreator(private val luckyNumber: Int) {
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