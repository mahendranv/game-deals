package com.ex2.game_data.domain

import com.ex2.game_data.domain.models.Deal
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlin.random.Random

internal object DataFaker {

    private val random = Random(24)

    fun randomDate() = LocalDate(
        year = random.nextInt(1980, 2024),
        monthNumber = random.nextInt(1, 12),
        dayOfMonth = random.nextInt(1, 28)
    )

    fun randomTime() = LocalTime(
        hour = random.nextInt(0, 23),
        minute = random.nextInt(1, 59),
        second = random.nextInt(1, 59)
    )

    fun randomDateTime(): LocalDateTime = LocalDateTime(randomDate(), randomTime())

    fun randomTitle(): String {
        val seed = arrayOf(
            "Army",
            "Dead",
            "Cool",
            "Knight",
            "Blade",
            "Red",
            "Box",
            "Head",
            "Astro",
            "Mint",
            "Ski",
            "Window",
            "Dark"
        )
        val one = seed.random()
        val two = arrayOf("of", "in", "for", "takes", "raises", "keeps", "kicks", "splits").random()
        val three = seed.random()
        return "$one $two $three"
    }

    val mockImages = arrayOf(
        "https://picsum.photos/id/8/5000/3333",
        "https://picsum.photos/id/9/5000/3269",
        "https://picsum.photos/id/10/2500/1667",
        "https://picsum.photos/id/11/2500/1667",
        "https://picsum.photos/id/12/2500/1667",
        "https://picsum.photos/id/13/2500/1667",
        "https://picsum.photos/id/14/2500/1667",
        "https://picsum.photos/id/15/2500/1667",
        "https://picsum.photos/id/16/2500/1667",
        "https://picsum.photos/id/17/2500/1667",
        "https://picsum.photos/id/18/2500/1667",
        "https://picsum.photos/id/19/2500/1667",
        "https://picsum.photos/id/20/3670/2462",
        "https://picsum.photos/id/21/3008/2008",
        "https://picsum.photos/id/22/4434/3729",
        "https://picsum.photos/id/23/3887/4899",
        "https://picsum.photos/id/24/4855/1803",
        "https://picsum.photos/id/25/5000/3333"
    )

    fun generateDeals(n: Int) = List(n) {
        val normalPrice = random.nextInt(30, 100).toFloat()
        val savings = random.nextInt(1, 15)

        Deal(
            title = randomTitle(),
            thumbnail = mockImages.random(),
            releasedOn = randomDateTime(),
            updatedOn = randomDateTime(),
            onSale = random.nextBoolean(),
            dealRating = arrayOf("Good", "Bad", "Ugly", "Steal").random(),
            savings = savings,
            salePrice = normalPrice * (savings / 100),
            normalPrice = normalPrice
        )
    }
}