package com.liunata.timconv.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liunata.timconv.activities.ConverterActivity
import com.liunata.timconv.R
import com.liunata.timconv.models.Converter

class ConverterAdapter(
    private val converters: List<Converter>
) : RecyclerView.Adapter<ConverterAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtConverter: TextView =
            itemView.findViewById(R.id.txtConverter)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_converter, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val converter = converters[position]

        holder.txtConverter.text = converter.name

        holder.itemView.setOnClickListener {

            val intent = Intent(
                holder.itemView.context,
                ConverterActivity::class.java
            )

            intent.putExtra(
                "converter",
                converter.name
            )

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return converters.size
    }
}