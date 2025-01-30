package com.example.superapp.state_management.homeworkAssignment1

sealed interface TodoAction {
    data class TodoAction(val isDone: Boolean) :
        com.example.superapp.state_management.homeworkAssignment1.TodoAction
}