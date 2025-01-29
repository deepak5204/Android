package com.example.superapp.state_management.number__guess

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NumberGuessViewModel: ViewModel() {

    private val _state = MutableStateFlow(NumberGuessState())
    val state = _state.asStateFlow()


    fun onAction(action: NumberGuessAction) {
        when(action) {
            NumberGuessAction.OnGuessClick -> {

            }
            is NumberGuessAction.OnNumberTextChange -> {
                _state.update { it.copy( // copy: create new instance while allowing us to change individual fields like numberText
                    numberText = action.numberText
                ) }
            }
            NumberGuessAction.OnStartNewGameButtonClick -> {

            }
        }
    }
}