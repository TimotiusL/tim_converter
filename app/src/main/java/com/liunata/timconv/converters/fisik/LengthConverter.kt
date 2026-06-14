package com.liunata.timconv.converters.fisik

object LengthConverter {

    private val units = mapOf(
        "Millimeter" to 0.001,
        "Centimeter" to 0.01,
        "Meter" to 1.0,
        "Kilometer" to 1000.0,
        "Inch" to 0.0254,
        "Feet" to 0.3048,
        "Yard" to 0.9144,
        "Mile" to 1609.34,
        "Nautical Mile" to 1852.0
    )

    fun convert(
        value: Double,
        from: String,
        to: String
    ): Double {

        val meterValue = value * units[from]!!
        return meterValue / units[to]!!
    }
}