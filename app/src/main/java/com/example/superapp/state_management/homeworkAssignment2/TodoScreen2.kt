package com.example.superapp.state_management.homeworkAssignment2

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.superapp.state_management.homeworkAssignment1.TodoAction
import com.example.superapp.state_management.homeworkAssignment1.TodoState
import com.example.superapp.ui.theme.SuperAppTheme

@Composable
fun TodoScreen2(
    modifier: Modifier = Modifier,
    onAction: (TodoAction) -> Unit,
    state: TodoState) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(0.8f),
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically)
        ) {
            Text(
                text = state.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textDecoration = if (state.isChecked) TextDecoration.LineThrough else null,
            )
            Text(
                text = state.description,
                fontSize = 20.sp,
                textDecoration = if (state.isChecked) TextDecoration.LineThrough else null,
            )
        }

        Checkbox(
            checked = false,
//            state.isChecked,
            onCheckedChange = {
//                isChecked ->
//                onAction(TodoAction.TodoAction(isChecked))
            },
            modifier = modifier.weight(0.1f)
                .align(Alignment.CenterVertically)
        )

        IconButton(
            onClick = {},
            modifier = modifier.weight(0.1f)
        ) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = null)
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun TodoScreen2Preview() {

    SuperAppTheme {
        TodoScreen2(
            modifier = Modifier,
            onAction = {},
            state = TodoState()
        )
    }

}