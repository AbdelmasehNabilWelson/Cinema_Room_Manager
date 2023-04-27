class Cinema (val rowNumb: Int, val seatNumb: Int) {
    val cinemalist = MutableList(rowNumb) {MutableList(seatNumb) {"S"}}

    fun printCinema() {
        println("Cinema:")
        print("  ")
        for (i in 1..seatNumb) {
            print("$i ")
        }
        println()
        for (i in 0 until rowNumb) {
            print("${i + 1}")
            for (j in cinemalist[i]) {
                print(" $j")
            }
            println()
        }
        println()
    }

    var numberOfPurchasedTickets = 0
    var count = 0
    val totlaNumberOfSeats = rowNumb * seatNumb

    var userInputRow = 0
    var percent = 0.0
    var percentage = "0.00"

    fun buy() {
        while (true) {
            println("Enter a row number:")
            val rowOfUser = readln().toInt()
            println("Enter a seat number in that row:")
            val seatOfUser = readln().toInt()
            userInputRow = seatOfUser
            try {
                if (cinemalist[rowOfUser- 1][seatOfUser - 1] == "B") {
                    println("\nThat ticket has already been purchased!\n")
                    continue
                } else {
                    print("\nTicket price: ")
                    if (totlaNumberOfSeats <= 60) {
                        print("$10")
                        currentIncome += 10 // calculating current income
                    } else {
                        if (rowOfUser <= rowNumb / 2) {
                            print("$10")
                            currentIncome += 10 // calculating current income
                        } else {
                            print("$8")
                            currentIncome += 8 // calculating current income
                        }
                    }
                    println("\n")
                    cinemalist[rowOfUser- 1][seatOfUser - 1] = "B"
                    numberOfPurchasedTickets += 1
                    val newTotlaSeats: Double = totlaNumberOfSeats.toDouble()
                    percent = 100 * (numberOfPurchasedTickets / newTotlaSeats)
                    percentage = String.format("%.2f", percent)
                    break
                }
            } catch (e: IndexOutOfBoundsException) {
                println("Wrong input!")
            }

        }
    }

    // caculating total income
    var currentIncome = 0
    var totlaIncome = 0

    init {
        if (totlaNumberOfSeats <= 60) {
            totlaIncome = 10 * totlaNumberOfSeats // calculating total income if the number of seats <= 60
        } else {
            totlaIncome += 10 * (rowNumb  / 2) * seatNumb // calculating total income if the number of seats > 60
            totlaIncome += 8 *((rowNumb - rowNumb  / 2) * seatNumb) // calculating total income if the number of seats > 60
        }
    }

    fun statistics() {
        println("Number of purchased tickets: $numberOfPurchasedTickets")
        println("Percentage: $percentage%")
        println("Current income: $$currentIncome")
        println("Total income: $$totlaIncome\n")
    }
}