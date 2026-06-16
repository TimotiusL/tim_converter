package com.liunata.timconv.converters.`fun`

object MorseCodeConverter {

    private val morseMap = mapOf(
        "A" to ".-",
        "B" to "-...",
        "C" to "-.-.",
        "D" to "-..",
        "E" to ".",
        "F" to "..-.",
        "G" to "--.",
        "H" to "....",
        "I" to "..",
        "J" to ".---",
        "K" to "-.-",
        "L" to ".-..",
        "M" to "--",
        "N" to "-.",
        "O" to "---",
        "P" to ".--.",
        "Q" to "--.-",
        "R" to ".-.",
        "S" to "...",
        "T" to "-",
        "U" to "..-",
        "V" to "...-",
        "W" to ".--",
        "X" to "-..-",
        "Y" to "-.--",
        "Z" to "--.."
    )

    fun textToMorse(text: String): String {

        return text.uppercase()
            .mapNotNull { morseMap[it.toString()] }
            .joinToString(" ")
    }
}