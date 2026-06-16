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
import java.time.temporal.ChronoUnit
import java.util.Calendar

class DateDifferenceActivity : AppCompatActivity() {

    private var startDate: LocalDate? = null
    private var endDate: LocalDate? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_date_difference)

        val btnStartDate =
            findViewById<Button>(R.id.btnStartDate)

        val btnEndDate =
            findViewById<Button>(R.id.btnEndDate)

        val btnCalculate =
            findViewById<Button>(R.id.btnCalculate)

        val txtResult =
            findViewById<TextView>(R.id.txtResult)

        btnStartDate.setOnClickListener {
            showDatePicker { date ->
                startDate = date
                btnStartDate.text = date.toString()
            }
        }

        btnEndDate.setOnClickListener {
            showDatePicker { date ->
                endDate = date
                btnEndDate.text = date.toString()
            }
        }

        btnCalculate.setOnClickListener {

            if (startDate == null || endDate == null) {

                txtResult.text =
                    "Please select both dates"

                return@setOnClickListener
            }

            val days =
                ChronoUnit.DAYS.between(
                    startDate,
                    endDate
                )

            txtResult.text =
                "$days Days"
        }
    }

    private fun showDatePicker(
        callback: (LocalDate) -> Unit
    ) {

        val calendar = Calendar.getInstance()

        DatePickerDialog(
            this,
            { _, year, month, day ->

                callback(
                    LocalDate.of(
                        year,
                        month + 1,
                        day
                    )
                )

            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }
}