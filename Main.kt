package machine

fun main() {
    println("Write how many ml of water the coffee machine has: ")
    val water = readLine()!!.toInt()
    println("Write how many ml of milk the coffee machine has: ")
    val milk = readLine()!!.toInt()
    println("Write how many grams of coffee beans the machine has: ")
    val beans = readLine()!!.toInt()

    val requestedCups = askNumberOfCups()
    val cupCapacity = getMaximumCups(water, milk, beans)

    checkRequestedCups(requestedCups, cupCapacity)
}

fun checkRequestedCups(requestedCups: Int, cupCapacity: Int) {
    val extraCups = cupCapacity - requestedCups
    when {
        cupCapacity > requestedCups -> {
            println("Yes, I can make that amount of coffee " +
                    "(and even $extraCups more than that)")
        }
        cupCapacity == requestedCups -> {
            println("Yes, I can make that amount of coffee")
        } else -> {
        println("No, I can only make $cupCapacity cups of coffee")
    }
    }
}

fun getMaximumCups(water: Int, milk: Int, beans: Int): Int {
    val maxWater = water / 200
    val maxMilk = milk / 50
    val maxBeans = beans / 15

    return minOf(maxWater, maxMilk, maxBeans)
}

fun askNumberOfCups(): Int {
    println("Write how many cups of coffee you will need:")
    val cups = readLine()!!.toInt()
    return cups
}

fun getReqWater(cups: Int): Int {
    return cups * 200
}

fun getReqMilk(cups: Int): Int {
    return cups * 50
}

fun getReqBeans(cups: Int): Int {
    return cups * 15
}

fun printIngredients(cups: Int) {
    val water = getReqWater(cups)
    val milk = getReqMilk(cups)
    val beans = getReqBeans(cups)

    println("For $cups cups of coffee you will need:")
    println("$water ml of water")
    println("$milk ml of milk")
    println("$beans g of coffee beans")
}
