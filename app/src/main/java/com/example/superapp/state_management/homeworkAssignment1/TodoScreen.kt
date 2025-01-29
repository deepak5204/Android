package com.example.superapp.state_management.homeworkAssignment1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.superapp.ui.theme.SuperAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import kotlin.math.sqrt


@Composable
fun TodoScreenRoot(modifier: Modifier = Modifier){
    val viewModel = viewModel<TodoViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    TodoScreen(
        modifier = modifier,
        state = state,
        onAction = viewModel::todoAction
    )

}

@Composable
fun TodoScreen(
    modifier: Modifier = Modifier,
    state: TodoState,
    onAction: (TodoAction) -> Unit
) {
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
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            if (!state.isChecked) {
                Text(
                    text = state.title, fontSize = 20.sp, fontWeight = FontWeight.Bold
                )
                Text(
                    text = state.description,
                    fontSize = 20.sp,
                )
            } else {
                Text(
                    text = state.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.LineThrough
                )
                Text(
                    text = state.description,
                    fontSize = 20.sp,
                    textDecoration = TextDecoration.LineThrough
                )
            }

        }

        Checkbox(
            checked = state.isChecked,
            onCheckedChange = {isChecked ->
                onAction(TodoAction.isTodoDone(isChecked))
            },
            modifier = modifier.weight(0.2f)
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun HomeworkAssignmentPreview() {
    SuperAppTheme {
        TodoScreen(
            modifier = Modifier,
            onAction = {},
            state = TodoState()
        )
    }

}