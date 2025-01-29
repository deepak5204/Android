package com.example.superapp.state_management.number__guess

data class NumberGuessState(
    val numberText: String = "1234",
    val guessText: String? = "",
    val isGuessCorrect: Boolean = false
)
