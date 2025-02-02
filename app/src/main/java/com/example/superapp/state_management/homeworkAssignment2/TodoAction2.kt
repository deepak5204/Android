package com.example.superapp.state_management.homeworkAssignment2

//sealed interface TodoAction2 {
//    data class UpdateTodo(val id: Int) : TodoAction2
//    data class DeleteTodo(val id: Int) : TodoAction2
//}

sealed interface TodoAction2 {
    data class AddTodo(val title: String, val description: String) : TodoAction2
    data class ToggleCheck(val id: Int, val isChecked: Boolean) : TodoAction2
    data class DeleteTodo(val id: Int) : TodoAction2
}