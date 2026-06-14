package com.liunata.timconv.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liunata.timconv.R
import com.liunata.timconv.activities.CategoryActivity
import com.liunata.timconv.models.Category

class CategoryAdapter(
    private val categories: List<Category>
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val category = categories[position]

        holder.txtTitle.text = category.title

        holder.itemView.setOnClickListener {

            val intent = Intent(
                holder.itemView.context,
                CategoryActivity::class.java
            )

            intent.putExtra("category", category.title)

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}