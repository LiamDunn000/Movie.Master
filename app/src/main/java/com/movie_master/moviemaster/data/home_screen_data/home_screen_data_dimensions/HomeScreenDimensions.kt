package com.movie_master.moviemaster.data.home_screen_data.home_screen_data_dimensions

import androidx.compose.ui.unit.dp
import com.movie_master.moviemaster.data.shared_data.screenDimensions

class HomeScreenDimensions {

    val homeScreenPadding = screenDimensions.screenSize * 0.01
    val homeScreenSpacing = screenDimensions.screenSize * 0.02

    // Category Header Dimensions
    val categoryHeaderFontSize = screenDimensions.screenSize * 0.016
    val categoryHeaderLetterSpacing = screenDimensions.screenSize * 0.001
    val categoryHeaderSpacing = screenDimensions.screenSize * 0.01
    val categoryHeaderDividerHeight = screenDimensions.screenSize * 0.0002

    // Movie Selection List Dimensions
    val movieSelectionListHeight = screenDimensions.screenSize * 0.23
    val movieSelectionListSpacing = screenDimensions.screenSize * 0.02

    // Movie Selection List Item Dimensions
    val movieSelectionListItemWidth = screenDimensions.screenSize * 0.12
    val movieSelectionListItemPadding = screenDimensions.screenSize * 0.0053
    val movieSelectionListItemCornerRadius = 10.dp
    val movieSelectionListItemElevation = screenDimensions.screenSize * 0.01
    val movieSelectionListItemImageHeight = screenDimensions.screenSize * 0.19
    val movieSelectionListItemTitleFontSize = screenDimensions.screenSize * 0.010
    val movieSelectionListItemDetailsFontSize = screenDimensions.screenSize * 0.009

    // Large Media Selection List Item Dimensions
    val largeMediaSelectionListItemWidth = screenDimensions.screenSize * 0.24
    val largeMediaSelectionListItemHeight = screenDimensions.screenSize * 0.215
    val largeMediaSelectionListItemBackgroundImageHeight = 0.92f
    val largeMediaSelectionListItemBackgroundImageCornerRadius = 10
    val largeMediaSelectionListItemElevation = screenDimensions.screenSize * 0.01

    // Large Media Selection List Item Details Dimensions
    val largeMediaSelectionListItemTitleFontSize = screenDimensions.screenSize * 0.014
    val largeMediaSelectionListItemTitleLetterSpacing = screenDimensions.screenSize * 0.001
    val largeMediaSelectionListItemTitleHorizontalPadding = screenDimensions.screenSize * 0.013
    val largeMediaSelectionListItemTitleVerticalPadding = screenDimensions.screenSize * 0.01
    val largeMediaSelectionListItemImageSize = screenDimensions.screenSize * 0.12
    val largeMediaSelectionListItemImageStartMargin = screenDimensions.screenSize * 0.025
    val largeMediaSelectionListItemDetailsFontSize = screenDimensions.screenSize * 0.014
    val largeMediaSelectionListItemDetailsBottomMargin = screenDimensions.screenSize * 0.035
    val largeMediaSelectionListItemDetailsEndMargin = screenDimensions.screenSize * 0.025
    val largeMediaSelectionListItemDetailsPadding = screenDimensions.screenSize * 0.0055

}