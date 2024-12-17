package com.movie_master.moviemaster.data.add_to_list_dialog_data.add_to_list_dialog_states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AddToListDialogStates: ViewModel() {

    companion object {
    var isAddToListDialogVisible by mutableStateOf(false)
    }
}