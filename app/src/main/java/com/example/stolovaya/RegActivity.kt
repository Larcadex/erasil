package com.example.stolovaya

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reg)


        val backButton = findViewById<Button>(R.id.backButton)
        val registerButton = findViewById<Button>(R.id.loginButton)
        val numEditText = findViewById<EditText>(R.id.numEditText)
        val loginEditText = findViewById<EditText>(R.id.loginEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)

        backButton.setOnClickListener {
            finish()
        }

    }
}
