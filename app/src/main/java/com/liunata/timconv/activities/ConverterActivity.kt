package com.liunata.timconv.activities

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.liunata.timconv.R

class ConverterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_converter)

        val txtConverterName =
            findViewById<TextView>(R.id.txtConverterName)

        val converterName =
            intent.getStringExtra("converter")

        txtConverterName.text = converterName
    }
}