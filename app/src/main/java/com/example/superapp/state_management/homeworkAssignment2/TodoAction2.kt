package com.example.superapp.state_management.homeworkAssignment2

sealed interface TodoAction2 {
    data class TodoAction2(val isDone: Boolean):
        com.example.superapp.state_management.homeworkAssignment2.TodoAction2
}