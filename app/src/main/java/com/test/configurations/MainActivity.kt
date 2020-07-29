package com.test.configurations

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnChangeDatetime.setOnClickListener {
            openSettingsAndroid(
                Settings.ACTION_DATE_SETTINGS,
                R.string.message_error_config_datetime
            )
        }

        btnChangeStatus4G.setOnClickListener {
            openSettingsAndroid(
                Settings.ACTION_DATA_ROAMING_SETTINGS,
                R.string.message_error_config_mobile_data
            )
        }

        btnChangeKeyboard.setOnClickListener {
            val imeManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imeManager.showInputMethodPicker()
        }
    }

    private fun openSettingsAndroid(settings: String, resIdMessageError: Int) {
        val intent = Intent(settings)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(
                this,
                getString(resIdMessageError),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}