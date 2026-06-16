package com.liunata.timconv.converters.fisik

object VolumeConverter {

    private val units = mapOf(
        "Milliliter" to 0.001,
        "Liter" to 1.0,
        "Gallon" to 3.78541,
        "Pint" to 0.473176,
        "Cup" to 0.236588,
        "Barrel" to 158.987
    )

    fun convert(
        value: Double,
        from: String,
        to: String
    ): Double {

        val literValue = value * units[from]!!
        return literValue / units[to]!!
    }
}