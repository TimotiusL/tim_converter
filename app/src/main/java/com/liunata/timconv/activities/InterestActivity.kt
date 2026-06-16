package com.liunata.timconv.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.liunata.timconv.R

class InterestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_interest)

        val etPrincipal =
            findViewById<EditText>(R.id.etPrincipal)

        val etRate =
            findViewById<EditText>(R.id.etRate)

        val etYears =
            findViewById<EditText>(R.id.etYears)

        val btnCalculate =
            findViewById<Button>(R.id.btnCalculate)

        val txtResult =
            findViewById<TextView>(R.id.txtResult)

        btnCalculate.setOnClickListener {

            if (
                etPrincipal.text.isEmpty() ||
                etRate.text.isEmpty() ||
                etYears.text.isEmpty()
            ) {

                txtResult.text =
                    "Please fill all fields"

                return@setOnClickListener
            }

            val principal =
                etPrincipal.text.toString().toDouble()

            val rate =
                etRate.text.toString().toDouble()

            val years =
                etYears.text.toString().toDouble()

            val result =
                principal *
                        (1 + (rate / 100) * years)

            txtResult.text =
                "Final Amount : $result"
        }
    }
}