package com.liunata.timconv.converters.fisik

object TimeConverter {

    private val units = mapOf(
        "Millisecond" to 0.001,
        "Second" to 1.0,
        "Minute" to 60.0,
        "Hour" to 3600.0,
        "Day" to 86400.0,
        "Week" to 604800.0,
        "Month" to 2628000.0,
        "Year" to 31536000.0
    )

    fun convert(
        value: Double,
        from: String,
        to: String
    ): Double {

        val secondValue = value * units[from]!!
        return secondValue / units[to]!!
    }
}