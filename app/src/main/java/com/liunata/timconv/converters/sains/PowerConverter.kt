package com.liunata.timconv.converters.sains

object PowerConverter {

    private val units = mapOf(
        "Watt" to 1.0,
        "Kilowatt" to 1000.0,
        "Megawatt" to 1000000.0,
        "Horsepower" to 745.7
    )

    fun convert(value: Double, from: String, to: String): Double {

        val wattValue = value * units[from]!!
        return wattValue / units[to]!!
    }
}