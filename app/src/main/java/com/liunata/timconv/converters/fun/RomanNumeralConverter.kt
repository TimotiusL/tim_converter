package com.liunata.timconv.converters.`fun`

object RomanNumeralConverter {

    fun convert(number: Int): String {

        val values = intArrayOf(
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        )

        val symbols = arrayOf(
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
        )

        var num = number
        var result = ""

        for (i in values.indices) {
            while (num >= values[i]) {
                result += symbols[i]
                num -= values[i]
            }
        }

        return result
    }
}