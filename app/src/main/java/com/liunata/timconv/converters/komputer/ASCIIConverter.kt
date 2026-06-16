package com.liunata.timconv.converters.komputer

object ASCIIConverter {

    fun textToAscii(text: String): String {
        return text.map { it.code }.joinToString(" ")
    }

    fun asciiToText(ascii: String): String {

        return ascii.split(" ")
            .mapNotNull {
                it.toIntOrNull()?.toChar()
            }
            .joinToString("")
    }
}