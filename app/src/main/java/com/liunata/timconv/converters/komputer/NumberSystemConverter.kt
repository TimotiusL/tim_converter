package com.liunata.timconv.converters.komputer

object NumberSystemConverter {

    fun convert(
        value: String,
        from: String,
        to: String
    ): String {

        val decimalValue = try {

            when(from) {

                "Binary" ->
                    value.toInt(2)

                "Octal" ->
                    value.toInt(8)

                "Hexadecimal" ->
                    value.toInt(16)

                else ->
                    value.toInt()
            }

        } catch (e: Exception) {

            return "Invalid Input"
        }

        return when(to) {

            "Binary" ->
                Integer.toBinaryString(decimalValue)

            "Octal" ->
                Integer.toOctalString(decimalValue)

            "Hexadecimal" ->
                Integer.toHexString(decimalValue)
                    .uppercase()

            else ->
                decimalValue.toString()
        }
    }
}