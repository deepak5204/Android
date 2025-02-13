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
                    println("ON_CREATE is called")
                }
                else -> Unit
//                Lifecycle.Event.ON_START -> TODO()
//                Lifecycle.Event.ON_RESUME -> TODO()
//                Lifecycle.Event.ON_PAUSE -> TODO()
//                Lifecycle.Event.ON_STOP -> TODO()
//                Lifecycle.Event.ON_DESTROY -> TODO()
//                Lifecycle.Event.ON_ANY -> TODO()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            println("onDispose is called")
            lifecycleOwner.lifecycle.removeObserver(observer )
        }
    }
}

@Preview
@Composable
private fun DisposableEffectDemoPreview() {
    
}