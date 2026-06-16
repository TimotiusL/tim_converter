package com.liunata.timconv.converters.komputer
import android.util.Base64

object TextEncodingConverter {
    fun encode(text: String): String {
        return Base64.encodeToString(
            text.toByteArray(),
            Base64.DEFAULT
        )
    }
    fun decode(text: String): String {

        return try {

            String(
                Base64.decode(
                    text,
                    Base64.DEFAULT
                )
            )

        } catch (e: Exception) {

            "Invalid Base64"
        }
    }
}