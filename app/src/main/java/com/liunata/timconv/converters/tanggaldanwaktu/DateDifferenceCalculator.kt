package com.liunata.timconv.converters.tanggaldanwaktu

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.temporal.ChronoUnit

object DateDifferenceCalculator {

    @RequiresApi(Build.VERSION_CODES.O)
    fun calculate(
        startDate: LocalDate,
        endDate: LocalDate
    ): Long {

        return ChronoUnit.DAYS.between(
            startDate,
            endDate
        )
    }
}