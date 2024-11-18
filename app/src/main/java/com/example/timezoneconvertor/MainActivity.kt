package com.example.timezoneconvertor

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.timezoneconvertor.R
import com.example.timezoneconvertor.ISTtoETActivity

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Button to check current ET and IST times
        val btnCurrentTime: Button = findViewById(R.id.btn_current_time)
        btnCurrentTime.setOnClickListener {
            // Navigate to CurrentTimeActivity
            startActivity(Intent(this, CurrentTimeActivity::class.java))
        }

        // Button to convert ET to IST
        val btnEtToIst: Button = findViewById(R.id.btn_et_to_ist)
        btnEtToIst.setOnClickListener {
            // Navigate to ETtoISTActivity
            startActivity(Intent(this, ETtoISTActivity::class.java))
        }

        // Button to convert IST to ET
        val btnIstToEt: Button = findViewById(R.id.btn_ist_to_et)
        btnIstToEt.setOnClickListener {
            // Navigate to ISTtoETActivity
            startActivity(Intent(this, ISTtoETActivity::class.java))
        }
    }
}
