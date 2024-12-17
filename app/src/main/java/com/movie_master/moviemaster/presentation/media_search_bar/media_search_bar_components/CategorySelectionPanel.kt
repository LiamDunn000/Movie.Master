package com.movie_master.moviemaster.presentation.media_search_bar.media_search_bar_components

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_dimensions.MediaSearchBarDimensions
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_states.mediaSearchBarStates

// Composable That Displays The Data Type Selection Buttons
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun CategorySelectionPanel(
    modifier: Modifier = Modifier,
    dimensions: MediaSearchBarDimensions = MediaSearchBarDimensions()) {

    // Category Selection Panel Layout
    Row(
        modifier
            .fillMaxWidth()
            .height(dimensions.categorySelectionPanelHeight.dp)
            .padding(horizontal = dimensions.categorySelectionPanelPadding.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){

        // Search All Button
        CategorySelectionButton(
            topStartCornerRadius = dimensions.categorySelectionButtonCornerRadius,
            bottomStartCornerRadius = dimensions.categorySelectionButtonCornerRadius,
            modifier = Modifier.weight(dimensions.categorySelectionButtonWeight),
            text = mediaSearchBarStates.searchableCategoryList[0]
        )

        // Search Movie Button
        CategorySelectionButton(
            modifier = Modifier.weight(dimensions.categorySelectionButtonWeight),
            text = mediaSearchBarStates.searchableCategoryList[1]
        )

        // Search TV Series Button
        CategorySelectionButton(
            modifier = Modifier.weight(dimensions.categorySelectionButtonWeight),
            text = mediaSearchBarStates.searchableCategoryList[2]
        )

        // Search Celebrity Button
        CategorySelectionButton(
            topEndCornerRadius = dimensions.categorySelectionButtonCornerRadius,
            bottomEndCornerRadius = dimensions.categorySelectionButtonCornerRadius,
            modifier = Modifier.weight(dimensions.categorySelectionButtonWeight),
            text = mediaSearchBarStates.searchableCategoryList[3]
        )
    }
}