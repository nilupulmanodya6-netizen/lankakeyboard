package com.lanka.keyboard.pro
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(50,50,50,50)
        }
        val title = TextView(this).apply { text = "LANKA KEYBOARD PRO"; textSize = 20f }
        val btnEnable = Button(this).apply { text = "ENABLE" }
        val btnChoose = Button(this).apply { text = "CHOOSE" }
        btnEnable.setOnClickListener { startActivity(Intent(Settings.ACTION_INPUT_METHOD_SETTINGS)) }
        btnChoose.setOnClickListener {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager
            imm.showInputMethodPicker()
        }
        layout.addView(title)
        layout.addView(btnEnable)
        layout.addView(btnChoose)
        setContentView(layout)
    }
}
