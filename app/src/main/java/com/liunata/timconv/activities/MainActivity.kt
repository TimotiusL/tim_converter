package com.liunata.timconv.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liunata.timconv.R
import com.liunata.timconv.adapters.CategoryAdapter
import com.liunata.timconv.models.Category

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerCategory)

        val categories = listOf(
            Category("Physical"),
            Category("Technology"),
            Category("Financial"),
            Category("Science"),
            Category("Daily Life"),
            Category("Date & Time"),
            Category("Fun")
        )

        adapter = CategoryAdapter(categories)

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
    }
}