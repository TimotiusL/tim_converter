package com.liunata.timconv.converters.fisik

object AreaConverter {

    private val units = mapOf(
        "Square Centimeter" to 0.0001,
        "Square Meter" to 1.0,
        "Square Kilometer" to 1000000.0,
        "Hectare" to 10000.0,
        "Acre" to 4046.86,
        "Square Feet" to 0.092903
    )

    fun convert(
        value: Double,
        from: String,
        to: String
    ): Double {

        val squareMeterValue = value * units[from]!!
        return squareMeterValue / units[to]!!
    }
}