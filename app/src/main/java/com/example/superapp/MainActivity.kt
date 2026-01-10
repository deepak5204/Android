package com.example.superapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.superapp.basic_modifiers.FocusManagementModifiers
import com.example.superapp.basic_modifiers.TriangleShape
import com.example.superapp.composition_locals.CompositionLocalDemo
import com.example.superapp.composition_locals.LocalShape
import com.example.superapp.composition_locals.MyApp
import com.example.superapp.composition_locals.MyShapedButton
import com.example.superapp.mesurements.LazyScrolling
import com.example.superapp.mesurements.SizePositionModifiersDemo
import com.example.superapp.mesurements.SubcomposePagedRow
import com.example.superapp.performance.ImageLoading
import com.example.superapp.performance.LazyListPerformance
import com.example.superapp.performance.MyScreen
import com.example.superapp.side_effect.DisposableEffectDemo
import com.example.superapp.side_effect.LaunchedEffectDemo
import com.example.superapp.side_effect.SideEffectDemo
import com.example.superapp.state_management.homeworkAssignment1.TodoScreenRoot
import com.example.superapp.state_management.homeworkAssignment2.TodoScreen2Root
import com.example.superapp.state_management.number__guess.NumberGuessScreenRoot
import com.example.superapp.ui.theme.SuperAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperAppTheme {
                CompositionLocalProvider(LocalShape provides TriangleShape) {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        LazyListPerformance(modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding))
                    }
                }


//                LazyScrolling(modifier = Modifier.padding(innerPadding))
//                MyShapedButton(modifier = Modifier.padding(innerPadding))
//                MyApp()

//                    var value by remember { mutableIntStateOf(0) }
//
//                    SideEffectDemo(
//                        modifier = Modifier,
//                        value = value
//                    )
//
//                    Button(
//                        onClick = {
//                            value++
//                        },
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .wrapContentSize()
//                    ) {
//                        Text(
//                            text = "Counter"
//                        )
//                    }


//                    var toggle by remember { mutableStateOf(false) }
//
//                    if(!toggle){
//                        DisposableEffectDemo(modifier = Modifier.padding(innerPadding))
//                    }
//
//                    Button(
//                        onClick = {
//                            toggle = !toggle
//                        },
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .wrapContentSize()
//                    ) {
//                        Text(text = "Toggle")
//                    }

//                    LaunchedEffectDemo()
//                    NumberGuessScreenRoot(modifier = Modifier.padding(innerPadding))
//                    TodoScreenRoot(modifier = Modifier.padding(innerPadding))
//                    TodoScreen2Root(modifier = Modifier.padding(innerPadding))

//                FocusManagementModifiers(modifier = Modifier.padding(innerPadding))

//                SizePositionModifiersDemo(modifier = Modifier.padding(innerPadding))

            }
        }
    }
}
