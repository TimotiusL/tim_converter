package com.liunata.timconv.converters.sains

object EnergyConverter {

    private val units = mapOf(
        "Joule" to 1.0,
        "Kilojoule" to 1000.0,
        "Calorie" to 4.184,
        "Kilocalorie" to 4184.0,
        "kWh" to 3600000.0
    )

    fun convert(value: Double, from: String, to: String): Double {

        val jouleValue = value * units[from]!!
        return jouleValue / units[to]!!
    }
}