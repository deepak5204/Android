package com.example.superapp.state_management.number__guess

sealed interface NumberGuessAction {
    data object OnGuessClick: NumberGuessAction
    data class OnNumberTextChange(val numberText: String): NumberGuessAction
    data object OnStartNewGameButtonClick: NumberGuessAction
}