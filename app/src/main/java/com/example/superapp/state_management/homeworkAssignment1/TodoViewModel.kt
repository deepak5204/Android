package com.example.superapp.state_management.homeworkAssignment1

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class TodoViewModel: ViewModel()  {

    private var _todo = MutableStateFlow(TodoState())
    var state = _todo.asStateFlow()

    fun todoAction(action: TodoAction) {
        when (action) {
            is TodoAction.TodoAction -> {
                val isChecked = state.value.isChecked

                if(isChecked == false){
                    _todo.update {
                        it.copy(
                            isChecked = true,
                        )
                    }
                }
                 else {
                    _todo.update {
                        it.copy(
                            isChecked = false,
                        )
                    }
                }
            }
        }
    }

}