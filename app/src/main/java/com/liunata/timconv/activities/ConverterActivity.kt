package com.liunata.timconv.activities

import android.os.Bundle
import android.text.InputType
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.liunata.timconv.R
import com.liunata.timconv.converters.fisik.LengthConverter
import com.liunata.timconv.converters.fisik.WeightConverter
import com.liunata.timconv.utils.ConverterData
import com.liunata.timconv.converters.*
import com.liunata.timconv.converters.finansial.CurrencyConverter
import com.liunata.timconv.converters.fisik.AreaConverter
import com.liunata.timconv.converters.fisik.SpeedConverter
import com.liunata.timconv.converters.fisik.TemperatureConverter
import com.liunata.timconv.converters.fisik.TimeConverter
import com.liunata.timconv.converters.fisik.VolumeConverter
import com.liunata.timconv.converters.komputer.ASCIIConverter
import com.liunata.timconv.converters.komputer.DataStorageConverter
import com.liunata.timconv.converters.komputer.InternetSpeedConverter
import com.liunata.timconv.converters.komputer.NumberSystemConverter
import com.liunata.timconv.converters.komputer.TextEncodingConverter
import com.liunata.timconv.converters.sains.AngleConverter
import com.liunata.timconv.converters.sains.EnergyConverter
import com.liunata.timconv.converters.sains.FrequencyConverter
import com.liunata.timconv.converters.sains.PowerConverter
import com.liunata.timconv.converters.sains.PressureConverter
import java.text.DecimalFormat

class ConverterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_converter)

        val txtConverterName =
            findViewById<TextView>(R.id.txtConverterName)

        val etValue =
            findViewById<EditText>(R.id.etValue)
        val spFrom =
            findViewById<Spinner>(R.id.spFrom)
        val spTo =
            findViewById<Spinner>(R.id.spTo)
        val btnConvert =
            findViewById<Button>(R.id.btnConvert)
        val txtResult =
            findViewById<TextView>(R.id.txtResult)
        val converterName =
            intent.getStringExtra("converter")
        val formatter =
            DecimalFormat("#,##0.######")

        txtConverterName.text = converterName
        when(converterName){
            "ASCII",
            "Text Encoding" -> {
                etValue.inputType =
                    InputType.TYPE_CLASS_TEXT
            }
            else -> {
                etValue.inputType =
                    InputType.TYPE_CLASS_NUMBER or
                            InputType.TYPE_NUMBER_FLAG_DECIMAL
            }
        }
        val units = when(converterName){
            "Length" -> ConverterData.lengthUnits
            "Weight" -> ConverterData.weightUnits
            "Area" -> ConverterData.areaUnits
            "Volume" -> ConverterData.volumeUnits
            "Speed" -> ConverterData.speedUnits
            "Temperature" -> ConverterData.temperatureUnits
            "Time" -> ConverterData.timeUnits
            "Data Storage" -> ConverterData.dataStorageUnits
            "Internet Speed" -> ConverterData.internetSpeedUnits
            "Number System" -> ConverterData.numberSystemUnits
            "ASCII" -> ConverterData.asciiUnits
            "Text Encoding" -> ConverterData.textEncodingUnits
            "Currency" -> ConverterData.currencyUnits
            "Pressure" -> ConverterData.pressureUnits
            "Energy" -> ConverterData.energyUnits
            "Power" -> ConverterData.powerUnits
            "Frequency" -> ConverterData.frequencyUnits
            "Angle" -> ConverterData.angleUnits
            else -> emptyList()
        }
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            units
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        spFrom.adapter = adapter
        spTo.adapter = adapter

        btnConvert.setOnClickListener {
            val input = etValue.text.toString()
            if(input.isEmpty()){
                txtResult.text = "Masukkan nilai terlebih dahulu"
                return@setOnClickListener
            }
            val from = spFrom.selectedItem.toString()
            val to = spTo.selectedItem.toString()

            if (converterName == "ASCII") {
                val result = if(from == "Text to ASCII") {
                    ASCIIConverter.textToAscii(input)
                } else {
                    ASCIIConverter.asciiToText(input)
                }
                txtResult.text =
                    "Result : ${formatter.format(result)}"
                return@setOnClickListener
            }
            if (converterName == "Text Encoding") {
                val result = if(from == "Encode") {
                    TextEncodingConverter.encode(input)
                } else {
                    TextEncodingConverter.decode(input)
                }
                txtResult.text =
                    "Result : ${formatter.format(result)}"
                return@setOnClickListener
            }
            if (converterName == "Number System") {
                val result = NumberSystemConverter.convert(input, from, to)
                txtResult.text =
                    "Result : ${formatter.format(result)}"
                return@setOnClickListener
            }
            val value =
                input.toDoubleOrNull()

            if(value == null){

                txtResult.text =
                    "Invalid input"

                return@setOnClickListener
            }

            val result = when(converterName){
                "Length" -> LengthConverter.convert(value, from, to)
                "Weight" -> WeightConverter.convert(value, from, to)
                "Area" -> AreaConverter.convert(value, from, to)
                "Volume" -> VolumeConverter.convert(value, from, to)
                "Speed" -> SpeedConverter.convert(value, from, to)
                "Temperature" -> TemperatureConverter.convert(value, from, to)
                "Time" -> TimeConverter.convert(value, from, to)
                "Data Storage" -> DataStorageConverter.convert(value, from, to)
                "Internet Speed" -> InternetSpeedConverter.convert(value, from, to)
                "Currency" -> CurrencyConverter.convert(value, from, to)
                "Pressure" -> PressureConverter.convert(value, from, to)
                "Energy" -> EnergyConverter.convert(value, from, to)
                "Power" -> PowerConverter.convert(value, from, to)
                "Frequency" -> FrequencyConverter.convert(value, from, to)
                "Angle" -> AngleConverter.convert(value, from, to)
                else -> 0.0
            }
            txtResult.text =
                "Result : ${formatter.format(result)}"
        }

        val btnSwap =
            findViewById<Button>(R.id.btnSwap)
        btnSwap.setOnClickListener {

            val fromPosition =
                spFrom.selectedItemPosition

            val toPosition =
                spTo.selectedItemPosition

            spFrom.setSelection(toPosition)
            spTo.setSelection(fromPosition)
        }
    }
}