package com.example.timezoneconvertor

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.timezoneconvertor.R
import java.text.SimpleDateFormat
import java.util.*

class CurrentTimeActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_time)

        val etTextView: TextView = findViewById(R.id.tv_et_time)
        val istTextView: TextView = findViewById(R.id.tv_ist_time)
        val refreshButton: Button = findViewById(R.id.btn_refresh)

        // Set initial time on load
        updateTime(etTextView, istTextView)

        // Refresh button to update the time
        refreshButton.setOnClickListener {
            updateTime(etTextView, istTextView)
        }
        val backButton: Button = findViewById(R.id.btn_back)
        backButton.setOnClickListener {
            // Go back to the previous activity (MainActivity)
            finish()
        }
    }

    private fun updateTime(etTextView: TextView, istTextView: TextView) {
        val dateFormat = SimpleDateFormat("EEEE, d MMM yyyy, hh:mm a", Locale.getDefault())

        // Get ET time
        dateFormat.timeZone = TimeZone.getTimeZone("America/New_York")
        val currentET = dateFormat.format(Date())
        etTextView.text = "$currentET"

        // Get IST time
        dateFormat.timeZone = TimeZone.getTimeZone("Asia/Kolkata")
        val currentIST = dateFormat.format(Date())
        istTextView.text = "$currentIST"
    }
}
