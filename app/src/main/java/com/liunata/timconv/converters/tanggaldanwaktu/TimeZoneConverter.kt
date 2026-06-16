package com.liunata.timconv.converters.tanggaldanwaktu

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime

object TimeZoneConverter {

    @RequiresApi(Build.VERSION_CODES.O)
    fun convert(
        dateTime: LocalDateTime,
        fromZone: String,
        toZone: String
    ): String {

        val source = ZonedDateTime.of(
            dateTime,
            ZoneId.of(fromZone)
        )

        val target =
            source.withZoneSameInstant(
                ZoneId.of(toZone)
            )

        return target.toString()
    }
}