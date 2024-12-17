package com.movie_master.moviemaster.data.details_screen_data.details_screen_dimensions

import androidx.compose.ui.unit.dp
import com.movie_master.moviemaster.data.shared_data.screenDimensions

class DetailsScreenDimensions {

    // DETAILS SCREEN HEADER DIMENSIONS ------------------------------------------------------------
    // Details Screen Header Dimensions
    val detailScreenHeaderPadding = screenDimensions.screenSize * 0.01
    val detailsScreenHeaderBackgroundImageHeight = screenDimensions.screenSize * 0.25

    // Details Screen Header Title Dimensions
    val detailsScreenHeaderTitleFontSize = screenDimensions.screenSize * 0.018
    val detailsScreenHeaderTitlePadding = screenDimensions.screenSize * 0.01
    val detailsScreenHeaderTitleLetterSpacing = screenDimensions.screenSize * 0.001
    val detailsScreenBackButtonSize = screenDimensions.screenSize * 0.025

    // Details Screen Header Image Dimensions
    val detailsScreenHeaderImageSize = screenDimensions.screenSize * 0.14
    val detailsScreenHeaderImageCornerRadius = 20
    val detailsScreenHeaderImageElevation = 10
    val detailsScreenHeaderImageStartMargin = screenDimensions.screenSize * 0.014

    // Details Screen Header Info Panel Dimensions
    val detailsScreenHeaderInfoPanelWidth = screenDimensions.screenSize * 0.5
    val detailsScreenHeaderInfoPanelExternalPadding = screenDimensions.screenSize * 0.165
    val detailsScreenHeaderInfoPanelInternalPadding = screenDimensions.screenSize * 0.015
    val detailsScreenHeaderInfoPanelSpacing = screenDimensions.screenSize * 0.01
    val detailsScreenHeaderInfoPanelBottomMargin = screenDimensions.screenSize * 0.01
    val detailsScreenHeaderInfoPanelEndMargin = screenDimensions.screenSize * 0.012
    val detailsScreenHeaderIconSize = screenDimensions.screenSize * 0.014
    val detailsScreenHeaderInfoPanelFontSize = screenDimensions.screenSize * 0.0125
    // ---------------------------------------------------------------------------------------------

    // DETAILS SCREEN BODY DIMENSIONS --------------------------------------------------------------

    val detailsScreenSpacing = screenDimensions.screenSize * 0.01

    // Details Screen Category Shared Dimensions
    val detailsScreenCategoryHeaderIconSize = screenDimensions.screenSize * 0.016
    val detailsScreenCategoryHeaderFontSize = screenDimensions.screenSize * 0.016
    val detailsScreenCategoryDetailsFontSize = screenDimensions.screenSize * 0.012
    val detailsScreenCategoryPadding = screenDimensions.screenSize * 0.01
    val detailsScreenListSpacing = screenDimensions.screenSize * 0.005
    val detailsScreenCategoryLetterSpacing = screenDimensions.screenSize * 0.0003
    val detailsScreenCategoryListItemCornerRadius = 10.dp
    val categoryListSpacing = screenDimensions.screenSize * 0.02

    // Details Screen Summary Dimensions
    val detailsScreenSummaryHeight = screenDimensions.screenSize * 0.12

    // Standard Details List Item Dimensions
    val standardDetailsListItemWidth = screenDimensions.screenSize * 0.12
    val standardDetailsListItemHeight = screenDimensions.screenSize * 0.215
    val standardDetailsListItemPadding = screenDimensions.screenSize * 0.0053
    val standardDetailsListItemElevation = screenDimensions.screenSize * 0.01
    val standardDetailsListItemImageHeight = screenDimensions.screenSize * 0.19
    val standardDetailsListItemTitleFontSize = screenDimensions.screenSize * 0.010

    // Image List Dimensions
    val imageListItemSize = screenDimensions.screenSize * 0.15

    // Review List Dimensions
    val reviewListItemSize = screenDimensions.screenSize * 0.18
    val reviewListItemPadding = screenDimensions.screenSize * 0.01
    val reviewContentFontSize = screenDimensions.screenSize * 0.012
    val reviewAuthorFontSize = screenDimensions.screenSize * 0.0115
    val reviewAuthorPadding = screenDimensions.screenSize * 0.005
    val noReviewMessageFontSize = screenDimensions.screenSize * 0.015

    // Full Review Dialog
    val fullReviewDialogWidth = screenDimensions.screenSize * 0.9
    val fullReviewDialogHeight = screenDimensions.screenSize * 0.5
    val fullReviewDialogSpacing = screenDimensions.screenSize * 0.008
    val fullReviewDialogHeaderCategoryFontSize = screenDimensions.screenSize * 0.012
    val fullReviewDialogHeaderContentFontSize = screenDimensions.screenSize * 0.013
    val fullReviewDialogDividerHeight = screenDimensions.screenSize * 0.0007
    val fullReviewDialogReviewContentFontSize = screenDimensions.screenSize * 0.013
    val fullReviewDialogReviewContentWeight = 1.5f
    val fullReviewDialogCloseButtonSize = screenDimensions.screenSize * 0.018
    val fullReviewDialogCloseButtonWeight = 0.1f

}