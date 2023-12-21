package com.example.project2

fun main() {
    println("Hello")
    val tamGiac = TamGiac(3, 4, 5)
    println("Chu vi tam giac: ${tamGiac.chuViTamGiac()}")
    val tamGiacVuong = TamGiacVuong(3, 4, 5)
    println("Chu vi tam giac vuong: ${tamGiacVuong.chuViTamGiac()}")
    val tamGiacCan = TamGiacCan(5, 6)
    println("Chu vi tam giac can: ${tamGiacCan.chuViTamGiac()}")
}

open class TamGiac constructor(val a: Int, val b: Int, val c: Int) {
    open fun chuViTamGiac(): Int {
        return a + b + c
    }
}

class TamGiacCan(a: Int, c: Int): TamGiac(a, a, c) {
    override fun chuViTamGiac(): Int {
        return a - b - c
    }
}

class TamGiacVuong(a: Int, b: Int, c: Int) : TamGiac(a, b, c) {
    override fun chuViTamGiac(): Int {
        return a * b * c
    }
}

