package com.liunata.timconv.converters.komputer

object DataStorageConverter {

    private val units = mapOf(
        "Bit" to 1.0,
        "Byte" to 8.0,
        "KB" to 8192.0,
        "MB" to 8388608.0,
        "GB" to 8589934592.0,
        "TB" to 8796093022208.0
    )

    fun convert(
        value: Double,
        from: String,
        to: String
    ): Double {

        val bitValue = value * units[from]!!
        return bitValue / units[to]!!
    }
}