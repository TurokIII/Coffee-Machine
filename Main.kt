package machine

fun main() {
    val machine = CoffeeMachine()
    askAction(machine)
}

fun askAction(machine: CoffeeMachine) {
    while (true) {
        println()
        println("Write action (buy, fill, take, remaining exit):")
        val action = readLine()!!

        if (action == "exit") break else machine.readInput(action)
    }
}