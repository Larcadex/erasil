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

class CartActivity : AppCompatActivity() {

    private val viewModel: MenuViewModel by viewModels()
    private lateinit var dishAdapter: DishAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart)

        // Устанавливаем RecyclerView для отображения элементов корзины
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        dishAdapter =
            DishAdapter(viewModel.cartItems.value ?: mutableListOf()) { /* Обработка изменения количества продуктов */ }
        recyclerView.adapter = dishAdapter

        // Наблюдаем за изменениями в корзине
        viewModel.cartItems.observe(this, Observer {
            dishAdapter.updateCartItems(it)
            updateTotalAmount()
        })

        // Отображаем общую сумму
        updateTotalAmount()

        // Кнопки навигации
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener { finish() }

        val qrButton: Button = findViewById(R.id.qrButton)
        qrButton.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updateTotalAmount() {
        val totalAmount: TextView = findViewById(R.id.totalAmount)
        val cartItems = viewModel.cartItems.value ?: mutableListOf()
        var totalPrice = 0
        for (item in cartItems) {
            totalPrice += item.price.toInt() * item.quantity
        }
        totalAmount.text = "Общая сумма: $totalPrice"
    }
}
