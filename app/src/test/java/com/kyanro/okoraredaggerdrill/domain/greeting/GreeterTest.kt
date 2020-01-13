package com.kyanro.okoraredaggerdrill.domain.greeting

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.time.LocalTime

// 多分多言語化とかするときに context を受け取るようになるので robolectric で実行してる
@RunWith(AndroidJUnit4::class)
class GreeterTest {
    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun 正しくあいさつされる_MEN_MORNING() {
        val greeter = Greeter(LocalTime.of(5, 0), Greeter.GreetingType.MEN)
        assertThat(greeter.greeting()).isEqualTo("おはよう")
    }

    @Test
    fun 正しくあいさつされる_CAT_MORNING() {
        val greeter = Greeter(LocalTime.of(5, 0), Greeter.GreetingType.CAT)
        assertThat(greeter.greeting()).isEqualTo("おはようにゃ")
    }

    @Test
    fun 正しくあいさつされる_CAT_NOON() {
        val greeter = Greeter(LocalTime.of(12, 0), Greeter.GreetingType.CAT)
        assertThat(greeter.greeting()).isEqualTo("こんにちはにゃ")
    }

    @Test
    fun 正しくあいさつされる_CAT_EVENING() {
        val greeter = Greeter(LocalTime.of(18, 0), Greeter.GreetingType.CAT)
        assertThat(greeter.greeting()).isEqualTo("こんばんはにゃ")
    }

    @Test
    fun 正しくあいさつされる_CAT_NOTHING() {
        val greeter = Greeter(LocalTime.of(3, 0), Greeter.GreetingType.CAT)
        assertThat(greeter.greeting()).isEqualTo("にゃーん")
    }
}