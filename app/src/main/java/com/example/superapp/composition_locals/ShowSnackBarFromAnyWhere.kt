package com.example.superapp.composition_locals

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// 1. Controller class
class SnackbarController(
    private val snackbarHostState: SnackbarHostState,
    private val coroutineScope: CoroutineScope
) {
    fun showSnackbar(
        message: String,
        actionLabel: String? = null,
        duration: SnackbarDuration = SnackbarDuration.Short
    ) {
        coroutineScope.launch {
            snackbarHostState.showSnackbar(
                message = message,
                actionLabel = actionLabel,
                duration = duration
            )
        }
    }
}

// 2. CompositionLocal definition
val LocalSnackbarController = staticCompositionLocalOf<SnackbarController> {
    error("SnackbarController not provided")
}

// 3. SnackbarProvider that sets up the controller and Scaffold
@Composable
fun SnackbarProvider(content: @Composable () -> Unit) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val controller = remember { SnackbarController(snackbarHostState, scope) }

    CompositionLocalProvider(LocalSnackbarController provides controller) {
        Scaffold(
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
        ) { innerPadding ->
            content()
        }
    }
}

// 4. Example composable that uses the controller
@Composable
fun SnackbarTriggerExample() {
    val snackbarController = LocalSnackbarController.current

    Button(
        onClick = {
        snackbarController.showSnackbar("Hello from nested composable!", "Dismiss")
    },
        modifier = Modifier.padding(16.dp)) {
        Text("Show SnackBar")
    }
}

// 5. App root
@Composable
fun MyApp() {
    SnackbarProvider {
        SnackbarTriggerExample()
    }
}
