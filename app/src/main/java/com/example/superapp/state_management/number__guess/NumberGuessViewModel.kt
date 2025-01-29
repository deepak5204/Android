package com.example.superapp.state_management.number__guess

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

class NumberGuessViewModel: ViewModel() {

    private var  number = Random.nextInt(1, 101)
    private var attempts = 0

    private val _state = MutableStateFlow(NumberGuessState())
    val state = _state.asStateFlow()


    fun onAction(action: NumberGuessAction) {
        when(action) {
            NumberGuessAction.OnGuessClick -> {
                val guess = state.value.numberText.toIntOrNull()
                if(guess != null) {
                    attempts++
                }

                _state.update {
                    it.copy(
                        guessText = when {
                            guess == null -> "Please Enter a number."
                            number > guess -> "Nope, my number is larger."
                            number < guess -> "Nope, my number is smaller."
                            else -> "That was it!, You needed $attempts attempts."
                        },
                        isGuessCorrect = number == guess,
                        numberText = "",
                    )
                }
            }
            is NumberGuessAction.OnNumberTextChange -> {
                _state.update { it.copy( // copy: create new instance while allowing us to change individual fields like numberText
                    numberText = action.numberText
                ) }
            }
            NumberGuessAction.OnStartNewGameButtonClick -> {
                number = Random.nextInt(1, 101)
                attempts = 0
                _state.update {
                    it.copy(
                        numberText = "",
                        guessText = null,
                        isGuessCorrect = false

                    )
                }
            }
        }
    }
}