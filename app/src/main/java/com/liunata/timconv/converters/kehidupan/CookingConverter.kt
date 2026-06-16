package com.liunata.timconv.converters.kehidupan

object CookingConverter {

    private val units = mapOf(
        "Teaspoon" to 1.0,
        "Tablespoon" to 3.0,
        "Cup" to 48.0,
        "Milliliter" to 0.202884
    )

    fun convert(
        value: Double,
        from: String,
        to: String
    ): Double {

        val tspValue = value * units[from]!!
        return tspValue / units[to]!!
    }
}