package com.example.counter

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel() : ViewModel() {
    private val counterRepository: CounterRepository = CounterRepository()
    private var _counter = mutableStateOf(counterRepository.getCount())

    var count: MutableState<Int> = _counter
    fun getter(): Int {
        return counterRepository.getCount()
    }

    fun increment() {
        counterRepository.incrementCounter()
        _counter.value = counterRepository.getCount()
    }

    fun decrement() {
        counterRepository.decrementCounter()
        _counter.value = counterRepository.getCount()
    }


}