package cinema

import Cinema


fun main() {
    println("Enter the number of rows:")
    val rowsNumb = readln().toInt()
    println("Enter the number of seats in each row:")
    val seatNumb = readln().toInt()
    println()
    val cinema = Cinema(rowsNumb,seatNumb)
    while(true) {
        println("""
            1. Show the seats
            2. Buy a ticket
            3. Statistics
            0. Exit
    """.trimIndent())
        val n = readln().toInt()
        println()
        when (n) {
            1 -> cinema.printCinema()
            2 -> cinema.buy()
            3 -> cinema.statistics()
            0 -> break
        }
    }
}