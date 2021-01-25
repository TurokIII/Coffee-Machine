package machine

data class Beverage(val water: Int, val milk: Int, val beans: Int, val money: Int) {
    companion object Factory {
        fun create(beverageName: String): Beverage {
            return when (beverageName) {
                "espresso" -> Beverage(250, 0, 16, 4)
                "latte" -> Beverage(350, 75, 20, 7)
                else -> Beverage(200, 100, 12, 6)
            }
        }
    }
}