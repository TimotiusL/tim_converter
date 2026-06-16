package com.liunata.timconv.converters.komputer

object InternetSpeedConverter {

    private val units = mapOf(
        "bps" to 1.0,
        "Kbps" to 1000.0,
        "Mbps" to 1000000.0,
        "Gbps" to 1000000000.0
    )

    fun convert(
        value: Double,
        from: String,
        to: String
    ): Double {

        val bpsValue = value * units[from]!!
        return bpsValue / units[to]!!
    }
}