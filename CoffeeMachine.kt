package machine

class CoffeeMachine {
    var money: Int = 550
    var water: Int = 400
    var milk: Int = 540
    var beans: Int = 120
    var cups: Int = 9

    fun readInput(input: String) {
        when (input) {
            "buy" -> buyCoffee()
            "fill" -> fillMachine()
            "take" -> takeMoney()
            "remaining" -> printState()
            else -> println("Please enter a valid action!")
        }
    }

    fun buyCoffee() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        val coffeeChoice = readLine()!!

        println()

        when (coffeeChoice) {
            "1" -> makeCoffee("espresso")
            "2" -> makeCoffee("latte")
            "3" -> makeCoffee("cappuccino")
            "back" -> {}
        }
    }

    fun makeCoffee(beverageName: String) {
        val drink = Beverage.create(beverageName)

        if (hasEnoughSupplies(drink)) {
            this.cups--
            this.water -= drink.water
            this.milk -= drink.milk
            this.beans -= drink.beans
            this.money += drink.money

            println("I have enough resources, making you a coffee!")
        }
    }

    fun hasEnoughSupplies(drink: Beverage): Boolean {
        if (this.cups <= 0) {
            println("Sorry, not enough cups!")
            return false
        }
        if (this.water < drink.water) {
            println("Sorry, not enough water!")
            return false
        }
        if (this.milk < drink.milk) {
            println("Sorry, not enough milk!")
            return false
        }
        if (this.beans < drink.beans) {
            println("Sorry, not enough beans!")
            return false
        }

        return true
    }

    fun fillMachine() {
        println("Write how many ml of water do you want to add:")
        this.water += readLine()!!.toInt()
        println("Write how many ml of milk do you want to add:")
        this.milk += readLine()!!.toInt()
        println("Write how many grams of coffee beans do you want to add:")
        this.beans += readLine()!!.toInt()
        println("Write how many disposable cups of coffee do you want to add:")
        this.cups += readLine()!!.toInt()

        println()
    }

    fun takeMoney() {
        println("I gave you $${this.money}")
        println()

        this.money = 0
    }


    fun printState() {
        println("The coffee machine has:")
        println("${this.water} of water")
        println("${this.milk} of milk")
        println("${this.beans} of coffee beans")
        println("${this.cups} of disposable cups")
        println("$${this.money} of money")
    }
}



