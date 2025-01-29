package com.example.superapp.state_management.homeworkAssignment1

sealed interface TodoAction {
    data class isTodoDone(val isDone: Boolean) : TodoAction
}