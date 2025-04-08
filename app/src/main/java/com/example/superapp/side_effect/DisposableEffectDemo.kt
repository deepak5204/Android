package com.example.superapp.side_effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner

@Composable
fun DisposableEffectDemo(modifier: Modifier = Modifier) {
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner.lifecycle) {
        val observer = LifecycleEventObserver { _, event ->
            when(event){
                Lifecycle.Event.ON_CREATE -> {
                    println("DisposableEffect: ON_CREATE is called")
                }
                Lifecycle.Event.ON_START -> {
                    println("DisposableEffect: Lifecycle Event: ON_START")
                }
                Lifecycle.Event.ON_RESUME -> {
                    println("DisposableEffect: Lifecycle Event: ON_RESUME")
                }
                Lifecycle.Event.ON_PAUSE -> {
                    println("DisposableEffect: Lifecycle Event: ON_PAUSE")
                }
                Lifecycle.Event.ON_STOP -> {
                    println("DisposableEffect: Lifecycle Event: ON_STOP")
                }
                Lifecycle.Event.ON_DESTROY -> {
                    println("DisposableEffect: Lifecycle Event: ON_DESTROY")
                }
                Lifecycle.Event.ON_ANY -> {
                    println("DisposableEffect: Lifecycle Event: ON_ANY")
                }
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            println("DisposableEffect: onDispose is called")
            lifecycleOwner.lifecycle.removeObserver(observer )
        }
    }
}

@Preview
@Composable
private fun DisposableEffectDemoPreview() {
    
}