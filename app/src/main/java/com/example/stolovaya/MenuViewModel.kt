import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stolovaya.Category

class MenuViewModel : ViewModel() {
    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> get() = _categories

    private val _cartItems = MutableLiveData<MutableList<Dish>>()
    val cartItems: LiveData<MutableList<Dish>> get() = _cartItems

    init {
        _categories.value = listOf(
            Category("Сладости", listOf(
                Dish("Торт", "1200"),
                Dish("Пирожное", "600"),
                Dish("Мороженое", "480"),
                Dish("Печенье", "200"),
                Dish("Шоколад", "400"),
                Dish("Кекс", "800"),
                Dish("Пудинг", "320")
            )),
            Category("Снеки", listOf(
                Dish("Чипсы", "200"),
                Dish("Сухарики", "160"),
                Dish("Орехи", "240"),
                Dish("Попкорн", "120"),
                Dish("Батончик", "160"),
                Dish("Фисташки", "800"),
                Dish("Сухофрукты", "480")
            )),
            Category("Напитки", listOf(
                Dish("Кофе", "400"),
                Dish("Чай", "200"),
                Dish("Сок", "320"),
                Dish("Лимонад", "160"),
                Dish("Коктейль", "480"),
                Dish("Молочный коктейль", "560"),
                Dish("Минеральная вода", "80")
            )),
            Category("Горячее", listOf(
                Dish("Суп", "800"),
                Dish("Паста", "1000"),
                Dish("Стейк", "2000"),
                Dish("Карри", "1200"),
                Dish("Лазанья", "1600"),
                Dish("Бургер", "600"),
                Dish("Котлета", "800")
            )),
            Category("Выпечка", listOf(
                Dish("Хлеб", "120"),
                Dish("Булочка", "160"),
                Dish("Пирог", "600"),
                Dish("Багет", "200"),
                Dish("Круассан", "400"),
                Dish("Рогалик", "320"),
                Dish("Пита", "240")
            ))
        )
        _cartItems.value = mutableListOf()
    }

    fun addToCart(dish: Dish) {
        val existingItem = _cartItems.value?.find { it.name == dish.name }
        if (existingItem != null) {
            existingItem.quantity++
        } else {
            val newCartItem = dish.copy(quantity = 1)
            _cartItems.value?.add(newCartItem)
        }
        _cartItems.value = _cartItems.value
    }

    fun clearCart() {
        _cartItems.value?.clear()
        _cartItems.value = _cartItems.value
    }
    fun updateCart(updatedCart: List<Dish>) {
        _cartItems.value = updatedCart.toMutableList()
    }

}
