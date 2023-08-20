package com.example.colourchanger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.colourchanger.ui.theme.ColourChangerTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColourChangerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val vm = viewModel<MyViewModel>()
                    Scaffold(
                        modifier = Modifier.fillMaxSize()
                    ) {padding ->
                        Column (modifier = Modifier
                            .padding(padding)
                            .background(color = vm.color)
                            .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally){
                            Button(onClick = { vm.setBgColor() }) {
                                Text(text = "Change color")
                            }
                        }
                    }
                }
            }
        }
    }
}

class MyViewModel: ViewModel(){
    var color by mutableStateOf(androidx.compose.ui.graphics.Color.Green)
    private set

    fun setBgColor(){
        color = androidx.compose.ui.graphics.Color.Magenta
    }
}