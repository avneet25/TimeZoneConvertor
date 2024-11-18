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

class ISTtoETActivity : Activity() {

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_ist_to_et)

                val inputIST: EditText = findViewById(R.id.et_input_et_time)
                val convertButton: Button = findViewById(R.id.btn_convert_et_to_ist)
                val outputET: TextView = findViewById(R.id.tv_converted)

                convertButton.setOnClickListener {
                        val istDateTime = inputIST.text.toString()
                        outputET.text = convertIstToEt(istDateTime)
                }

                val backButton: Button = findViewById(R.id.btn_back)
                backButton.setOnClickListener {
                        // Go back to the previous activity (MainActivity)
                        finish()
                }
        }

        private fun convertIstToEt(istDateTime: String): String {
                // Format for IST (Indian Standard Time)
                val istFormat = SimpleDateFormat("yyyy-MM-dd hh:mm a", Locale.getDefault())
                istFormat.timeZone = TimeZone.getTimeZone("Asia/Kolkata")

                // Format for ET (Eastern Time)
                val etFormat = SimpleDateFormat("EEEE, d MMM yyyy, hh:mm a", Locale.getDefault())
                etFormat.timeZone = TimeZone.getTimeZone("America/New_York")

                return try {
                        // Parse IST time and convert it to ET
                        val date = istFormat.parse(istDateTime)
                        etFormat.format(date!!)
                } catch (e: Exception) {
                        "Invalid Date Format"
                }
        }
}
