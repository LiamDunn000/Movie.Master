package com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_colors

import com.movie_master.moviemaster.data.shared_data.colors

val mediaSearchBarColors = MediaSearchBarColors()

class MediaSearchBarColors {

    val mediaSearchBarBackgroundColor = colors.darkBlue

    // Data Search Bar Text Field Colors
    val dataSearchBarTextFieldContainerColor = colors.transparent
    val dataSearchBarTextFieldCursorColor = colors.darkWhite25Percent
    val dataSearchBarTextFieldIndicatorColor = colors.transparent
    val dataSearchBarTextFieldBorderColor = colors.darkWhite25Percent
    val dataSearchBarTextFieldIconColor = colors.darkWhite25Percent
    val dataSearchBarTextFieldTextColor = colors.darkWhite50Percent

    // Category Selection Button Colors
    val unselectedCategorySelectionButtonColor = colors.transparent
    val selectedCategorySelectionButtonColor = colors.cyan70Percent
    val unselectedCategorySelectionButtonBorderColor = colors.darkWhite25Percent
    val selectedCategorySelectionButtonBorderColor = colors.white
    val unselectedCategorySelectionButtonTextColor = colors.darkWhite80Percent
    val selectedCategorySelectionButtonTextColor = colors.white

    // Search Result Item Colors
    val searchResultItemTitleTextColor = colors.darkWhite80Percent
    val searchResultItemDetailsTextColor = colors.darkWhite50Percent
    val searchResultListItemBorderColor = colors.darkWhite25Percent
}