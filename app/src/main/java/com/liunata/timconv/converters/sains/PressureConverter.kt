package com.liunata.timconv.converters.sains

object PressureConverter {

    private val units = mapOf(
        "Pascal" to 1.0,
        "Kilopascal" to 1000.0,
        "Bar" to 100000.0,
        "PSI" to 6894.76,
        "Atmosphere" to 101325.0
    )

    fun convert(value: Double, from: String, to: String): Double {

        val pascalValue = value * units[from]!!
        return pascalValue / units[to]!!
    }
}