package com.liunata.timconv.converters.finansial

object CurrencyConverter {

    private val rates = mapOf(
        "IDR" to 1.0,
        "USD" to 16300.0,
        "EUR" to 18500.0,
        "JPY" to 110.0,
        "SGD" to 12500.0
    )

    fun convert(
        value: Double,
        from: String,
        to: String
    ): Double {

        val idrValue = value * rates[from]!!
        return idrValue / rates[to]!!
    }
}