package com.liunata.timconv.converters.fisik

object SpeedConverter {

    private val units = mapOf(
        "Meter/Second" to 1.0,
        "Kilometer/Hour" to 0.277778,
        "Mile/Hour" to 0.44704,
        "Knot" to 0.514444
    )

    fun convert(
        value: Double,
        from: String,
        to: String
    ): Double {

        val msValue = value * units[from]!!
        return msValue / units[to]!!
    }
}