package com.example.superapp.state_management.homeworkAssignment2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.superapp.ui.theme.SuperAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue



@Composable
fun TodoScreen2Root(modifier: Modifier = Modifier) {
    val viewModel: TodoViewModel2 = viewModel()
    val todoList by viewModel.todoList.collectAsStateWithLifecycle()

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        todoList.forEach { todo ->
            TodoScreen2(
                modifier = modifier
                    .fillMaxWidth(),
                state = todo,
                onAction = viewModel::todoAction2
            )
        }

        AddTodo(
            modifier = modifier
            .fillMaxWidth(),
            viewModel, onAction =
            viewModel::todoAction2
        )

    }
}

@Composable
fun AddTodo(modifier: Modifier = Modifier, viewModel: TodoViewModel2,
            onAction: (TodoAction2) -> Unit) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .padding(bottom = 12.dp)
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )

        IconButton(
            onClick = {
                if (title.isNotBlank() && description.isNotBlank()) {
                    onAction(TodoAction2.AddTodo(title, description))
                    title = ""
                    description = ""
                }
            },
            modifier = Modifier.align(Alignment.End) // ✅ Align button correctly
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Todo"
            )
        }
    }
}

@Composable
fun TodoScreen2(
    modifier: Modifier = Modifier,
    state: TodoState2,
    onAction: (TodoAction2) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(0.8f),
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
                fontSize = 16.sp,
                textDecoration = if (state.isChecked) TextDecoration.LineThrough else null,
            )
        }

        Checkbox(
            checked = state.isChecked,
            onCheckedChange = { isChecked ->
                onAction(TodoAction2.ToggleCheck(state.id, isChecked))
            },
            modifier = Modifier.weight(0.1f)
        )

        IconButton(
            onClick = {
                onAction(TodoAction2.DeleteTodo(state.id))
            },
            modifier = Modifier.weight(0.1f)
        ) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
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
            state = TodoState2(id = 1)
        )
    }
}

