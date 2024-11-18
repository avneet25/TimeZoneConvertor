package com.example.timezoneconvertor

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.timezoneconvertor.R
import java.text.SimpleDateFormat
import java.util.*

class ETtoISTActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_et_to_ist)

        val inputET: EditText = findViewById(R.id.et_input_et_time)
        val convertButton: Button = findViewById(R.id.btn_convert_et_to_ist)
        val outputIST: TextView = findViewById(R.id.tv_converted)

        convertButton.setOnClickListener {
            val etDateTime = inputET.text.toString()
            outputIST.text = convertEtToIst(etDateTime)
        }
        val backButton: Button = findViewById(R.id.btn_back)
        backButton.setOnClickListener {
            // Go back to the previous activity (MainActivity)
            finish()
        }
    }

    private fun convertEtToIst(etDateTime: String): String {
        val etFormat = SimpleDateFormat("yyyy-MM-dd hh:mm a", Locale.getDefault())
        etFormat.timeZone = TimeZone.getTimeZone("America/New_York")

        val istFormat = SimpleDateFormat("EEEE, d MMM yyyy, hh:mm a", Locale.getDefault())
        istFormat.timeZone = TimeZone.getTimeZone("Asia/Kolkata")

        return try {
            val date = etFormat.parse(etDateTime)
            istFormat.format(date!!)
        } catch (e: Exception) {
            "Invalid Date Format"
        }
    }
}