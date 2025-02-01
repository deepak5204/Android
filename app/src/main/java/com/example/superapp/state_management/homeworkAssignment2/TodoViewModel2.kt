package com.example.superapp.state_management.homeworkAssignment2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoViewModel2: ViewModel() {

    private var _todo2 = MutableStateFlow(TodoState2())
    var state2 = _todo2.asStateFlow()


    fun todoAction2(action: TodoAction2) {
        when (action) {
            is TodoAction2.TodoAction2 -> {
                val isChecked = state2.value.isChecked

                if(isChecked == false){
                    _todo2.update {
                        it.copy(
                            isChecked = true,
                        )
                    }
                }
                else {
                    _todo2.update {
                        it.copy(
                            isChecked = false,
                        )
                    }
                }
            }
        }
    }


}