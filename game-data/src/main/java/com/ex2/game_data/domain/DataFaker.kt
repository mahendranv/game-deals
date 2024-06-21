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

    fun generateDeals(n: Int) = List(n) {
        val normalPrice = random.nextInt(30, 100).toFloat()
        val savings = random.nextInt(1, 15)


        Deal(
            title = randomTitle(),
            thumbnail = "https://www.cheapshark.com/img/logo_image.png?v=1.0",
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