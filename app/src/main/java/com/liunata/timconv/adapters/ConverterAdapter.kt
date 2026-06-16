package com.liunata.timconv.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liunata.timconv.activities.ConverterActivity
import com.liunata.timconv.R
import com.liunata.timconv.activities.AgeActivity
import com.liunata.timconv.activities.DateDifferenceActivity
import com.liunata.timconv.activities.DiscountActivity
import com.liunata.timconv.activities.InterestActivity
import com.liunata.timconv.activities.TimeZoneActivity
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

            val context = holder.itemView.context

            val intent = when (converter.name) {

                "Discount" ->
                    Intent(context, DiscountActivity::class.java)

                "Interest" ->
                    Intent(context, InterestActivity::class.java)

                "Age Calculator" ->
                    Intent(context, AgeActivity::class.java)

                "Date Difference" ->
                    Intent(context, DateDifferenceActivity::class.java)

                "Time Zone Converter" ->
                    Intent(context, TimeZoneActivity::class.java)

                else -> {
                    Intent(
                        context,
                        ConverterActivity::class.java
                    ).apply {
                        putExtra(
                            "converter",
                            converter.name
                        )
                    }
                }
            }

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return converters.size
    }
}