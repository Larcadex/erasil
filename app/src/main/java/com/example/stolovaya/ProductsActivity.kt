package com.example.stolovaya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.products)

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }

        val qrButton: Button = findViewById(R.id.qrButton)
        qrButton.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }

        val cartButton: Button = findViewById(R.id.cartButton)
        cartButton.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        val drinksButton: Button = findViewById(R.id.drinksButton)
        drinksButton.setOnClickListener {
            openMenuActivity("Напитки")
        }

        val hotButton: Button = findViewById(R.id.hotButton)
        hotButton.setOnClickListener {
            openMenuActivity("Горячее")
        }

        val bakeryButton: Button = findViewById(R.id.bakeryButton)
        bakeryButton.setOnClickListener {
            openMenuActivity("Выпечка")
        }

        val sweetsButton: Button = findViewById(R.id.sweetsButton)
        sweetsButton.setOnClickListener {
            openMenuActivity("Сладости")
        }

        val snacksButton: Button = findViewById(R.id.snacksButton)
        snacksButton.setOnClickListener {
            openMenuActivity("Снеки")
        }
    }

    private fun openMenuActivity(category: String) {
        val intent = Intent(this, MenuActivity::class.java)
        intent.putExtra("CATEGORY_NAME", category)
        startActivity(intent)
    }
}
