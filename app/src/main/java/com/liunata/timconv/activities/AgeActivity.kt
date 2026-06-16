package com.liunata.timconv.activities

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.liunata.timconv.R
import java.time.LocalDate
import java.time.Period
import java.util.Calendar

class AgeActivity : AppCompatActivity() {

    private var birthDate: LocalDate? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_age)

        val btnPickDate =
            findViewById<Button>(R.id.btnPickDate)

        val btnCalculate =
            findViewById<Button>(R.id.btnCalculate)

        val txtResult =
            findViewById<TextView>(R.id.txtResult)

        btnPickDate.setOnClickListener {

            val calendar =
                Calendar.getInstance()

            val year =
                calendar.get(Calendar.YEAR)

            val month =
                calendar.get(Calendar.MONTH)

            val day =
                calendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(
                this,
                { _, y, m, d ->

                    birthDate =
                        LocalDate.of(
                            y,
                            m + 1,
                            d
                        )

                    btnPickDate.text =
                        "$d/${m + 1}/$y"

                },
                year,
                month,
                day
            ).show()
        }

        btnCalculate.setOnClickListener {

            if (birthDate == null) {

                txtResult.text =
                    "Please select birth date"

                return@setOnClickListener
            }

            val age =
                Period.between(
                    birthDate,
                    LocalDate.now()
                )

            txtResult.text =
                "${age.years} Years\n" +
                        "${age.months} Months\n" +
                        "${age.days} Days"
        }
    }
}