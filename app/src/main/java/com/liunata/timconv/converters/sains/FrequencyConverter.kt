package com.liunata.timconv.converters.sains

object FrequencyConverter {

    private val units = mapOf(
        "Hertz" to 1.0,
        "Kilohertz" to 1000.0,
        "Megahertz" to 1000000.0,
        "Gigahertz" to 1000000000.0
    )

    fun convert(value: Double, from: String, to: String): Double {

        val hertzValue = value * units[from]!!
        return hertzValue / units[to]!!
    }
}