package com.example.superapp.state_management.homeworkAssignment2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update



class TodoViewModel2 : ViewModel() {

    private val _todoList = MutableStateFlow<List<TodoState2>>(emptyList())
    val todoList = _todoList.asStateFlow()

    private var idCounter = 1

    fun todoAction2(action: TodoAction2) {
        when (action) {
            is TodoAction2.AddTodo -> {
                _todoList.update { currentList ->
                    currentList + TodoState2(
                        id = idCounter++,
                        title = action.title,
                        description = action.description
                    )
                }
            }

            is TodoAction2.ToggleCheck -> {
                _todoList.update { currentList ->
                    currentList.map { todo ->
                        if (todo.id == action.id) {
                            todo.copy(isChecked = !todo.isChecked)
                        } else todo
                    }
                }
            }

            is TodoAction2.DeleteTodo -> {
                _todoList.update { currentList ->
                    currentList.filterNot { it.id == action.id }
                }
            }

        }
    }
}
