package com.example.superapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.superapp.side_effect.DisposableEffectDemo
import com.example.superapp.side_effect.LaunchedEffectDemo
import com.example.superapp.state_management.homeworkAssignment1.TodoScreenRoot
import com.example.superapp.state_management.homeworkAssignment2.TodoScreen2Root
import com.example.superapp.state_management.number__guess.NumberGuessScreenRoot
import com.example.superapp.ui.theme.SuperAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    var toggle by remember { mutableStateOf(false) }

                    if(!toggle){
                        DisposableEffectDemo(modifier = Modifier.padding(innerPadding))
                    }

                    Button(
                        onClick = {
                            toggle = !toggle
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize()
                    ) {
                        Text(text = "Toggle")
                    }

//                    LaunchedEffectDemo()
//                    NumberGuessScreenRoot(modifier = Modifier.padding(innerPadding))
//                    TodoScreenRoot(modifier = Modifier.padding(innerPadding))
//                    TodoScreen2Root(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
