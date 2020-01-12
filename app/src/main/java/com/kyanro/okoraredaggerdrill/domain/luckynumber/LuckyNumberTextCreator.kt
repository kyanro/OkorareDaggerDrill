package com.kyanro.okoraredaggerdrill.domain.luckynumber

import com.kyanro.okoraredaggerdrill.dagger.AppScope
import javax.inject.Inject

@AppScope
class LuckyNumberTextCreator @Inject constructor(private val luckyNumber: Int) {
    fun luckyNumberText() = "今日のラッキーナンバー: $luckyNumber"
}