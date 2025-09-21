package main.kotlin

fun add(a: Int, b: Int): Int {
    return a + b
}

fun subtract(a: Int, b: Int): Int {
    return a - b
}

fun divide(a: Int, b: Int): Int {
    require(b != 0) { "Division by zero is not allowed" }
    return a / b
}

fun main() {
    println("2 + 3 = ${add(2, 3)}")
    println("5 - 2 = ${subtract(5, 2)}")
    println("10 / 2 = ${divide(10, 2)}")
}
