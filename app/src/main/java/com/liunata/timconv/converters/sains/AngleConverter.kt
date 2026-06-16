package com.liunata.timconv.converters.sains

object AngleConverter {

    private val units = mapOf(
        "Degree" to 1.0,
        "Radian" to 57.2958,
        "Gradian" to 0.9
    )

    fun convert(value: Double, from: String, to: String): Double {

        val degreeValue = value * units[from]!!
        return degreeValue / units[to]!!
    }
}