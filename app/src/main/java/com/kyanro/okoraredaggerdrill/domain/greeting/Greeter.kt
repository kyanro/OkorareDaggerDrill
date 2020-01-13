package com.kyanro.okoraredaggerdrill.domain.greeting

import com.kyanro.okoraredaggerdrill.dagger.FragmentScope
import java.time.LocalTime

@FragmentScope
class Greeter(private val time: LocalTime, private val greetingType: GreetingType) {
    enum class GreetingType {
        MEN, WOMEN, GENTLEMAN, CAT
    }

    private fun GreetingType.greeting(): String {
        return when (this) {
            GreetingType.MEN -> when (time.greetingTime()) {
                GreetingTime.MORNING -> "おはよう"
                else -> time.greetingTime().standardGreeting
            }
            GreetingType.WOMEN -> time.greetingTime().standardGreeting
            GreetingType.GENTLEMAN -> time.greetingTime().standardGreeting
            GreetingType.CAT -> when (time.greetingTime()) {
                GreetingTime.MORNING -> "おはようにゃ"
                GreetingTime.NOON -> "こんにちはにゃ"
                GreetingTime.EVENING -> "こんばんはにゃ"
                GreetingTime.NOTHING -> "にゃーん"
            }
        }
    }

    private enum class GreetingTime(val standardGreeting: String) {
        MORNING("おはようございます"),
        NOON("こんにちは"),
        EVENING("こんばんは"),
        NOTHING("")
    }

    private fun LocalTime.greetingTime() = when (this.hour) {
        in 5..11 -> GreetingTime.MORNING
        in 12..17 -> GreetingTime.NOON
        in 18..23 -> GreetingTime.EVENING
        else -> GreetingTime.NOTHING
    }

    fun greeting(): String = greetingType.greeting()
}