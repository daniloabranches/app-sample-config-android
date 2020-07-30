package com.test.configurations

import android.content.ComponentName
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
            openDateSettings()
        }

        btnChangeStatus4G.setOnClickListener {
            openDataUsageSettings()
        }

        btnChangeKeyboard.setOnClickListener {
            openKeyboardSettings()
        }
    }

    private fun openDateSettings() {
        val intent = Intent(Settings.ACTION_DATE_SETTINGS)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(
                this,
                getString(R.string.message_error_config_datetime),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun openDataUsageSettings() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.component = ComponentName(
            "com.android.settings",
            "com.android.settings.Settings\$DataUsageSummaryActivity"
        )
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(
                this,
                getString(R.string.message_error_config_mobile_data),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun openKeyboardSettings() {
        val imeManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imeManager.showInputMethodPicker()
    }
}