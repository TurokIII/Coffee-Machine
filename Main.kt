package machine

fun main() {
//    println("Write how many ml of water the coffee machine has: ")
//    val water = readLine()!!.toInt()
//    println("Write how many ml of milk the coffee machine has: ")
//    val milk = readLine()!!.toInt()
//    println("Write how many grams of coffee beans the machine has: ")
//    val beans = readLine()!!.toInt()
//
//    val requestedCups = askNumberOfCups()
//    val cupCapacity = getMaximumCups(water, milk, beans)
//
//    checkRequestedCups(requestedCups, cupCapacity)
    val money = 550
    val water = 400
    val milk = 540
    val beans = 120
    val cups = 9

    printState(cups, water, milk, beans, money)
    askAction(cups, water, milk, beans, money)

}

fun askAction(cups: Int, water: Int, milk: Int, beans: Int, money: Int) {
    println("Write action (buy, fill, take):")
    val action = readLine()!!

    when (action) {
        "buy" -> buyCoffee(cups,water, milk, beans, money)
        "fill" -> fillMachine(cups, water, milk, beans, money)
        "take" -> takeMoney(cups, water, milk, beans, money)
    }
}

fun buyCoffee(cups: Int, water: Int, milk: Int, beans: Int, money: Int) {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino")
    val coffeeChoice = readLine()!!

    println()

    when (coffeeChoice) {
        "1" -> printState(cups - 1,water - 250, milk, beans - 16, money + 4)
        "2" -> printState(cups - 1, water - 350, milk - 75, beans - 20, money + 7)
        "3" -> printState(cups - 1, water - 200, milk - 100, beans - 12, money + 6)
    }
}

fun fillMachine(cups: Int, water: Int, milk: Int, beans: Int, money: Int) {
    println("Write how many ml of water do you want to add:")
    val newWater = readLine()!!.toInt()
    println("Write how many ml of milk do you want to add:")
    val newMilk = readLine()!!.toInt()
    println("Write how many grams of coffee beans do you want to add:")
    val newBeans = readLine()!!.toInt()
    println("Write how many disposable cups of coffee do you want to add:")
    val newCups = readLine()!!.toInt()

    println()

    printState(cups + newCups, water + newWater, milk + newMilk, beans + newBeans, money)
}

fun takeMoney(cups: Int, water: Int, milk: Int, beans: Int, money: Int) {
    println("I gave you $$money")
    println()
    printState(cups, water, milk, beans, 0)
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

fun printState(cups: Int, water: Int, milk: Int, beans: Int, money: Int) {
    println("The coffee machine has:")
    println("$water of water")
    println("$milk of milk")
    println("$beans of coffee beans")
    println("$cups of disposable cups")
    println("$money of money")
}
