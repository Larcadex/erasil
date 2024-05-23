package com.example.stolovaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.code)

        val backButton = findViewById<Button>(R.id.backButton)

        // Устанавливаем слушатель кликов по кнопке
        backButton.setOnClickListener {
            // Вызываем метод finish(), чтобы вернуться к предыдущей активности в стеке
            finish()
        }
    }


}