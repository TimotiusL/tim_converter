package com.liunata.timconv.converters.`fun`

object RGBConverter {

    fun rgbToHex(
        r: Int,
        g: Int,
        b: Int
    ): String {

        return String.format(
            "#%02X%02X%02X",
            r,
            g,
            b
        )
    }
}