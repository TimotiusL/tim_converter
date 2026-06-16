package com.liunata.timconv.converters.fisik

object WeightConverter {

    private val units = mapOf(
        "Milligram" to 0.001,
        "Gram" to 1.0,
        "Kilogram" to 1000.0,
        "Ton" to 1000000.0,
        "Ounce" to 28.3495,
        "Pound" to 453.592,
        "Stone" to 6350.29
    )

    fun convert(
        value: Double,
        from: String,
        to: String
    ): Double {

        val gramValue = value * units[from]!!
        return gramValue / units[to]!!
    }
}