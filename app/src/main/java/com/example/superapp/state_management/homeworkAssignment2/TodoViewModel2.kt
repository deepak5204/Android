package com.example.superapp.state_management.homeworkAssignment2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TodoViewModel2: ViewModel() {

    private var _todo2 = MutableStateFlow(listOf(TodoState2()))
    var state2 = _todo2.asStateFlow()



}