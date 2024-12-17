package com.movie_master.moviemaster.functionality.general_operations

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_states.mediaSearchBarStates
import com.movie_master.moviemaster.data.shared_data.sharedStates
import com.movie_master.moviemaster.functionality.api_operations.searchDataOperations
import com.movie_master.moviemaster.functionality.user_interface_operations.userInterfaceOperations

val generalOperations = GeneralOperations()

class GeneralOperations: ViewModel() {

    // TOAST OPERATIONS ----------------------------------------------------------------------------
    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun showErrorLoadingDataMessage(context: Context, data: String) {
        showToast(context = context, message = "Error Loading $data")
    }

    fun showErrorAccessingAccountMessage(context: Context) {
        showToast(context = context, message = "Error Accessing Account")
    }

    fun showListResponseMessage(context: Context, result: String, listType: String) {
        generalOperations.showToast(context = context, userInterfaceOperations.determineMediaTitle(
            sharedStates.selectedMediaItem) + " ${if (result == "true") "Added To" else "Removed From"} $listType")
    }

    fun showErrorAddingToListMessage(context: Context, result: String, listType: String) {
        generalOperations.showToast(context = context, " Error ${if (result == "true") "Adding To" else "Removing From"} $listType")
    }
    // APP OPERATIONS ----------------------------------------------------------------------------

    fun closeApp(context: Context) {
        if (mediaSearchBarStates.isMediaSearchBarExpanded) {
            searchDataOperations.closeMediaSearchBar()
            searchDataOperations.clearMediaSearchBarFocus()
        } else {
            (context as? Activity)?.moveTaskToBack(true)
            searchDataOperations.clearMediaSearchBarFocus()
        }
    }
}