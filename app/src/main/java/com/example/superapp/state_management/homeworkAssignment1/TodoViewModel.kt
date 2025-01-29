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
            is TodoAction.isTodoDone -> {
                val isChecked = state.value.isChecked

                if (!isChecked) {
                    _todo.update {
                        it.copy(
                            isChecked = true,
                            title = "Brig out the trash",
                            description = "Better do this before wife comes home. ghajkldfs;akjdjfak;dfa"

                        )
                    }
                } else {
                    _todo.update {
                        it.copy(
                            isChecked = false,
                            title = "Brig out the trash",
                            description = "Better do this before wife comes home."
                        )
                    }
                }
            }
        }
    }

}