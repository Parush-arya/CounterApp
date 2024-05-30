package com.example.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.counter.ui.theme.CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: CounterViewModel = ViewModelProvider(this)[CounterViewModel(
            )::class.java]
            CounterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    CounterApp(modifier = Modifier.padding(it), viewModel)
                }
            }
        }
    }
}

@Composable
fun CounterApp(modifier: Modifier, viewModel: CounterViewModel) {
    fun increment() {
        viewModel.increment()
        println("increment")
    }

    fun decrement() {
        viewModel.decrement()
    }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Count: ${viewModel.count.value}", fontSize = 24.sp)
        Button(onClick = { increment() }, content = { Text(text = "Increment") })
        Button(onClick = { decrement() }, content = { Text(text = "decrement") })
    }
}