package machine

data class CoffeeMachine(
        var money: Int = 550,
        var water: Int = 400,
        var milk: Int = 540,
        var beans: Int = 120,
        var cups: Int = 9
)

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

    val machine = CoffeeMachine()

    askAction(machine)

}

fun askAction(machine: CoffeeMachine) {
    while (true) {
        println()
        println("Write action (buy, fill, take, remaining exit):")
        val action = readLine()!!

        when (action) {
            "buy" -> buyCoffee(machine)
            "fill" -> fillMachine(machine)
            "take" -> takeMoney(machine)
            "remaining" -> printState(machine)
            "exit" -> break
        }
    }
}

fun buyCoffee(machine: CoffeeMachine) {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    val coffeeChoice = readLine()!!

    println()

    when (coffeeChoice) {
        "1" -> makeEspresso(machine)
        "2" -> makeLatte(machine)
        "3" -> makeCappuccino(machine)
        "back" -> {}
    }

}

fun makeEspresso(machine: CoffeeMachine) {
    if (machine.cups <= 0) {
        println("Sorry, not enough cups!")
        return
    }
    if (machine.water < 250) {
        println("Sorry, not enough water!")
        return
    }
    if (machine.beans < 16) {
        println("Sorry, not enough beans!")
        return
    }

    machine.cups--
    machine.water -= 250
    machine.beans -= 16
    machine.money += 4

    println("I have enough resources, making you a coffee!")
}

fun makeLatte(machine: CoffeeMachine) {
    if (machine.cups <= 0) {
        println("Sorry, not enough cups!")
        return
    }
    if (machine.water < 350) {
        println("Sorry, not enough water!")
        return
    }
    if (machine.milk < 75) {
        println("Sorry, not enough milk!")
        return
    }
    if (machine.beans < 20) {
        println("Sorry, not enough beans!")
        return
    }

    machine.cups--
    machine.water -= 350
    machine.milk -= 75
    machine.beans -= 20
    machine.money += 7

    println("I have enough resources, making you a coffee!")
}

fun makeCappuccino(machine: CoffeeMachine) {
    if (machine.cups <= 0) {
        println("Sorry, not enough cups!")
        return
    }
    if (machine.water < 200) {
        println("Sorry, not enough water!")
        return
    }
    if (machine.milk < 100) {
        println("Sorry, not enough milk!")
        return
    }
    if (machine.beans < 12) {
        println("Sorry, not enough beans!")
        return
    }

    machine.cups--
    machine.water -= 200
    machine.milk -= 100
    machine.beans -= 12
    machine.money += 6

    println("I have enough resources, making you a coffee!")
}

fun fillMachine(machine: CoffeeMachine) {
    println("Write how many ml of water do you want to add:")
    machine.water += readLine()!!.toInt()
    println("Write how many ml of milk do you want to add:")
    machine.milk += readLine()!!.toInt()
    println("Write how many grams of coffee beans do you want to add:")
    machine.beans += readLine()!!.toInt()
    println("Write how many disposable cups of coffee do you want to add:")
    machine.cups += readLine()!!.toInt()

    println()
}

fun takeMoney(machine: CoffeeMachine) {
    println("I gave you $${machine.money}")
    println()

    machine.money = 0
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

fun printState(machine: CoffeeMachine) {
    println("The coffee machine has:")
    println("${machine.water} of water")
    println("${machine.milk} of milk")
    println("${machine.beans} of coffee beans")
    println("${machine.cups} of disposable cups")
    println("$${machine.money} of money")
}
