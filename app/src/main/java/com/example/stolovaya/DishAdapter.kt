package com.example.stolovaya

import Dish
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stolovaya.R

class DishAdapter(
    private var cartItems: List<Dish>,
    private val onQuantityChanged: (Dish) -> Unit
) : RecyclerView.Adapter<DishAdapter.DishViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dish, parent, false)
        return DishViewHolder(view)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        val dish = cartItems[position]
        holder.bind(dish)
    }

    override fun getItemCount() = cartItems.size

    fun updateCartItems(newCartItems: List<Dish>) {
        this.cartItems = newCartItems
        notifyDataSetChanged()
    }

    inner class DishViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.dishName)
        private val priceTextView: TextView = itemView.findViewById(R.id.dishPrice)
        private val quantityTextView: TextView = itemView.findViewById(R.id.quantityText)
        private val incrementButton: Button = itemView.findViewById(R.id.incrementButton)
        private val decrementButton: Button = itemView.findViewById(R.id.decrementButton)

        fun bind(dish: Dish) {
            nameTextView.text = dish.name
            priceTextView.text = dish.price
            quantityTextView.text = dish.quantity.toString()

            incrementButton.setOnClickListener {
                dish.quantity++
                quantityTextView.text = dish.quantity.toString()
                onQuantityChanged(dish)
            }

            decrementButton.setOnClickListener {
                if (dish.quantity > 0) {
                    dish.quantity--
                    quantityTextView.text = dish.quantity.toString()
                    onQuantityChanged(dish)
                }
            }
        }
    }
}
