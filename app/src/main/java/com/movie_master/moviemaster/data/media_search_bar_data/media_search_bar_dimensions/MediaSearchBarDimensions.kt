package com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_dimensions

import androidx.compose.ui.unit.dp
import com.movie_master.moviemaster.data.shared_data.screenDimensions

class MediaSearchBarDimensions {

    // Data Search Bar Dimensions
    val mediaSearchBarUnexpandedHeight = screenDimensions.screenSize * 0.075
    val mediaSearchBarExpandedHeight = screenDimensions.screenSize
    val mediaSearchBarSpacing = screenDimensions.screenSize * 0.02
    val mediaSearchBarElevation = screenDimensions.screenSize * 0.01

    // Data Search Bar Text Field Dimensions
    val dataSearchBarTextFieldHeight = screenDimensions.screenSize * 0.045
    val dataSearchBarTextFieldBorderWidth = screenDimensions.screenSize * 0.001
    val dataSearchBarTextFieldCornerRadius = 20.dp
    val dataSearchBarTextFieldExternalPadding = screenDimensions.screenSize * 0.012
    val dataSearchBarTextFieldInternalPadding = screenDimensions.screenSize * 0.008
    val dataSearchBarTextFieldIconSize = screenDimensions.screenSize * 0.029
    val dataSearchBarTextFieldFontSize = screenDimensions.screenSize * 0.015

    // Category Selection Panel Dimensions
    val categorySelectionPanelHeight = screenDimensions.screenSize * 0.030
    val categorySelectionPanelPadding = screenDimensions.screenSize * 0.01

    // Category Selection Button Dimensions
    val categorySelectionButtonWeight = 1f
    val categorySelectionButtonCornerRadius = 20.dp
    val categorySelectionBorderWidth = screenDimensions.screenSize * 0.001
    val categorySelectionButtonFontSize = screenDimensions.screenSize * 0.011

    // Search Result List Dimensions
    val searchResultListBorderWidth = screenDimensions.screenSize * 0.0005

    // Search Result Item Dimensions
    val searchResultListItemHeight = screenDimensions.screenSize * 0.10
    val searchResultListItemPadding = screenDimensions.screenSize * 0.007
    val searchResultListItemSpacing = screenDimensions.screenSize * 0.01
    val searchResultListItemBorderWidth = screenDimensions.screenSize * 0.0001
    val searchResultListItemTitleFontSize = screenDimensions.screenSize * 0.014
    val searchResultListItemDetailsFontSize = screenDimensions.screenSize * 0.012

}