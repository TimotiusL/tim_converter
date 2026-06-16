package com.liunata.timconv.activities

import android.os.Build
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.liunata.timconv.R
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime

class TimeZoneActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_time_zone)

        val spFromZone =
            findViewById<Spinner>(R.id.spFromZone)

        val spToZone =
            findViewById<Spinner>(R.id.spToZone)

        val btnConvert =
            findViewById<Button>(R.id.btnConvert)

        val txtResult =
            findViewById<TextView>(R.id.txtResult)

        val zones = listOf(
            "Asia/Jakarta",
            "Asia/Singapore",
            "Asia/Tokyo",
            "Europe/London",
            "America/New_York"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            zones
        )

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spFromZone.adapter = adapter
        spToZone.adapter = adapter

        btnConvert.setOnClickListener {

            val fromZone =
                spFromZone.selectedItem.toString()

            val toZone =
                spToZone.selectedItem.toString()

            val currentTime =
                ZonedDateTime.now(
                    ZoneId.of(fromZone)
                )

            val converted =
                currentTime.withZoneSameInstant(
                    ZoneId.of(toZone)
                )

            txtResult.text =
                converted.toString()
        }
    }
}