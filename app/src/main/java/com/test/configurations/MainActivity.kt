package com.test.configurations

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnChangeDatetime.setOnClickListener {
            startActivity(Intent(Settings.ACTION_DATE_SETTINGS))
        }

        btnChangeKeyboard.setOnClickListener {
            val imeManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imeManager.showInputMethodPicker()
        }

        btnChangeStatus4G.setOnClickListener {
            startActivity(Intent(Settings.ACTION_DATA_ROAMING_SETTINGS))
        }
    }
}