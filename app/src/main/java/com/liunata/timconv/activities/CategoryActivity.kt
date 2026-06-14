package com.liunata.timconv.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.liunata.timconv.R
import com.liunata.timconv.models.Converter
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liunata.timconv.adapters.ConverterAdapter

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        val category = intent.getStringExtra("category")
        val converters: List<Converter> = when(category) {

            "Physical" -> listOf(
                Converter("Length"),
                Converter("Weight"),
                Converter("Area"),
                Converter("Volume"),
                Converter("Speed"),
                Converter("Temperature"),
                Converter("Time")
            )

            "Technology" -> listOf(
                Converter("Data Storage"),
                Converter("Internet Speed"),
                Converter("Number System"),
                Converter("ASCII"),
                Converter("Text Encoding")
            )

            else -> emptyList()
        }
        val txtCategory = findViewById<TextView>(R.id.txtCategory)
        val recyclerConverter = findViewById<RecyclerView>(R.id.recyclerConverter)

        txtCategory.text = category

        recyclerConverter.layoutManager =
            LinearLayoutManager(this)

        recyclerConverter.adapter =
            ConverterAdapter(converters)
    }
}