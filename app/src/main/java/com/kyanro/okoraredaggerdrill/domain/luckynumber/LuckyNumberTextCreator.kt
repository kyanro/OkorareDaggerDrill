package com.kyanro.okoraredaggerdrill.domain.luckynumber

class LuckyNumberTextCreator(private val luckyNumber: Int) {
    fun luckyNumberText() = "今日のラッキーナンバー: $luckyNumber"
}