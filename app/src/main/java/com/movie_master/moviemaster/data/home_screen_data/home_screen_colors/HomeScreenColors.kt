package com.movie_master.moviemaster.data.home_screen_data.home_screen_colors

import com.movie_master.moviemaster.data.shared_data.colors

val homeScreenColors = HomeScreenColors()

class HomeScreenColors {

    val homeScreenBackgroundColor = colors.darkBlue

    // Category Header Colors
    val categoryHeaderTextColor = colors.darkWhite80Percent
    val categoryHeaderDividerColor = colors.darkWhite50Percent

    // Media Selection List Item Colors
    val mediaSelectionListItemContainerColor = colors.transparent
    val mediaSelectionListItemBackgroundColor = colors.darkBlue
    val mediaSelectionListItemTitleTextColor = colors.darkWhite80Percent
    val mediaSelectionListItemAgeRatingTextColor = colors.darkWhite50Percent
    val positiveMediaSelectionListItemReviewScoreTextColor = colors.cyan
    val averageMediaSelectionListItemReviewScoreTextColor = colors.yellow
    val negativeMediaSelectionListItemReviewScoreTextColor = colors.red
    val mediaSelectionListItemTextBackgroundColor = colors.black50Percent
}