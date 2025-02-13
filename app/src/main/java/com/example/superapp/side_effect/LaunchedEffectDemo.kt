package com.example.superapp.side_effect

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.superapp.ui.theme.SuperAppTheme

@Composable
fun LaunchedEffectDemo(modifier: Modifier = Modifier) {
    var counter by remember { mutableStateOf(0) }

    val snackbarHostState = remember {
        SnackbarHostState()
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->

    }

    LaunchedEffect(Unit) {
        launcher.launch(Manifest.permission.RECORD_AUDIO)
    }

    val scope = rememberCoroutineScope()

    LaunchedEffect(counter) { //there is no need of coroutine scope because this lambda has already suspending context
        if(counter % 2 == 0){
            snackbarHostState.showSnackbar("This is even number")
        }
    }

    Scaffold (
        modifier = modifier
            .fillMaxSize(),
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState
            )
        }
    ){ innerPadding ->
        Button(
            onClick = {
                counter++
//                if(counter % 2 == 0){
//                    scope.launch{
//                        snackbarHostState.showSnackbar("This number is even")
//                    }
//                }
            },
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .wrapContentSize()
        ) {
            Text(text = "Counter: $counter")
        }
    }

}


@Preview(showBackground = true)
@Composable
private fun LaunchedEffectDemoPreview() {
    SuperAppTheme {
        LaunchedEffectDemo()
    }
}