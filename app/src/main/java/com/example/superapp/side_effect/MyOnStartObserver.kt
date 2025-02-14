package com.example.superapp.side_effect

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superapp.ui.theme.SuperAppTheme
import kotlinx.coroutines.delay

@Composable
fun LaunchAnimation(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState,
    username: String
) {
    val updatedUserName by rememberUpdatedState(username)
    LaunchedEffect(username) {
        // Play animation
        // This shouldn't start when username changes
        delay(5000L)
        snackbarHostState.showSnackbar(
//            "Welcome to the app, $username!" // new five seconds delay if state change
            "Welcome to the app, $updatedUserName!" // no new five seconds delay, if state change
        )
    }
}


@Composable
fun RememberUpdatedStateDemo(modifier: Modifier = Modifier) {
    var username by remember {
        mutableStateOf("")
    }
    val snackbarHostState = remember {
        SnackbarHostState()
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            LaunchAnimation(
                snackbarHostState = snackbarHostState,
                username = username
            )

            TextField(
                value = username,
                onValueChange = {
                    username = it
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray),
                placeholder = {
                    Text(text = "Enter something")
                }
            )
        }

    }
}


@Preview
@Composable
private fun RememberUpdatedStateDemoPreview() {
    SuperAppTheme {
        RememberUpdatedStateDemo()
    }
}