package com.example.superapp.basic_modifiers

import android.R.attr.value
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusGroup
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superapp.ui.theme.SuperAppTheme
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.onFocusChanged

@Composable
fun FocusManagementModifiers(modifier: Modifier = Modifier) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .focusRequester(focusRequester),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        var isFocused by remember { mutableStateOf(false) }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = if(isFocused) Color.Blue else Color.Gray
                )
                .onFocusChanged { isFocused = it.hasFocus }
                .padding(16.dp)
                .focusGroup(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .focusRequester(focusRequester),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                ),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .focusRequester(focusRequester),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                ),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )
        }


        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .focusRequester(focusRequester),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )
        TextField(
            value = "",
            onValueChange = {}
        )

        Button(
            onClick = {
//               focusManager.moveFocus(FocusDirection.Down)
                focusRequester.requestFocus()

            }
        ) {
            Text(text = "Start filling out form")
        }

        Button(
            onClick = {
                focusManager.clearFocus()
            }
        ) {
            Text(text = "Clear focus")
        }
    }
}

@Preview
@Composable
private fun FocusManagementModifiersPreview() {
    SuperAppTheme {
        FocusManagementModifiers()
    }
}