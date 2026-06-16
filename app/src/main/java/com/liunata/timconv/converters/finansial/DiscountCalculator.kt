package com.liunata.timconv.converters.finansial

object DiscountCalculator {

    fun calculate(
        price: Double,
        discount: Double
    ): Double {

        return price - (price * discount / 100)
    }
}