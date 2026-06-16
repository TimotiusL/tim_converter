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

class DiscountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_discount)

        val etPrice =
            findViewById<EditText>(R.id.etPrice)

        val etDiscount =
            findViewById<EditText>(R.id.etDiscount)

        val btnCalculate =
            findViewById<Button>(R.id.btnCalculate)

        val txtResult =
            findViewById<TextView>(R.id.txtResult)

        btnCalculate.setOnClickListener {

            if (
                etPrice.text.isEmpty() ||
                etDiscount.text.isEmpty()
            ) {
                txtResult.text =
                    "Please fill all fields"
                return@setOnClickListener
            }

            val price =
                etPrice.text.toString().toDouble()

            val discount =
                etDiscount.text.toString().toDouble()

            val finalPrice =
                price - (price * discount / 100)

            txtResult.text =
                "Final Price : $finalPrice"
        }
    }
}