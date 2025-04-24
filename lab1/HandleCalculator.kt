package com.example.calculator

class HandleCalculator(val first_number: Int, val second_number : Int) {

    // handle calculator
    fun add() : Int {
        return first_number + second_number
    }

    fun sub() : Int {
        return first_number - second_number
    }

    fun mul() : Int {
        return first_number * second_number
    }

    fun div() : Int {
        return if (second_number != 0) (first_number / second_number) else 0
    }

    // check in which range
    fun checkRange (number: Int) : String{
        return when(number) {
            in 1..10 -> "Number is between 1 to 10"
            in 11..20 -> "Number is between 11 to 20"
            in 21..30 -> "Number is between 21 to 30"
            else -> "Number is our of range"
        }
    }

}