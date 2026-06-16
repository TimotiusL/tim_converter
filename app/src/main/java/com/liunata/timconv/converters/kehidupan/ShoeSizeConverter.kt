package com.liunata.timconv.converters.kehidupan

object ShoeSizeConverter {

    fun usToEu(us: Double): Double {
        return us + 33
    }

    fun euToUs(eu: Double): Double {
        return eu - 33
    }
}