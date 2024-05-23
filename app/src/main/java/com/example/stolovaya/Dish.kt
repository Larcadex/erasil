import java.io.Serializable

data class Dish(
    val name: String,
    val price: String,
    var quantity: Int = 0
) : Serializable