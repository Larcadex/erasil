package com.example.stolovaya

import MenuViewModel
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuActivity : AppCompatActivity() {

    private val viewModel: MenuViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)

        val qrButton: Button = findViewById(R.id.qrButton)
        qrButton.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }

        val cartButton: Button = findViewById(R.id.cartButton)
        cartButton.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        val categoryName = intent.getStringExtra("CATEGORY_NAME")
        val menuTitle: TextView = findViewById(R.id.menuTitle)
        menuTitle.text = categoryName

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.categories.observe(this, Observer { categories ->
            val selectedCategory = categories.find { it.name == categoryName }
            selectedCategory?.let {
                recyclerView.adapter = DishAdapter(it.dishes) { dish ->
                    viewModel.addToCart(dish)
                }
            }
        })
    }
}
