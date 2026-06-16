package com.liunata.timconv.converters.tanggaldanwaktu

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.Period

object AgeCalculator {

    @RequiresApi(Build.VERSION_CODES.O)
    fun calculate(
        birthDate: LocalDate
    ): String {

        val today = LocalDate.now()

        val age = Period.between(
            birthDate,
            today
        )

        return "${age.years} Years, ${age.months} Months, ${age.days} Days"
    }
}