package com.liunata.timconv.converters.finansial

object InterestCalculator {

    fun calculate(
        principal: Double,
        rate: Double,
        years: Double
    ): Double {

        return principal * (1 + (rate / 100) * years)
    }
}