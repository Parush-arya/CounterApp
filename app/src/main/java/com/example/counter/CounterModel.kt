package com.example.counter

data class CounterModel(var count: Int)

class CounterRepository {
    private var counter: CounterModel = CounterModel(0)
    fun getCount(): Int {
        return counter.count
    }

    fun incrementCounter() {
        counter.count++
    }

    fun decrementCounter() {
        counter.count--
    }
}