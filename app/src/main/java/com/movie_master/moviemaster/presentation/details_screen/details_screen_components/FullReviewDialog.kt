package com.movie_master.moviemaster.presentation.details_screen.details_screen_components

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.movie_master.moviemaster.data.details_screen_data.details_screen_colors.DetailsScreenColors
import com.movie_master.moviemaster.data.details_screen_data.details_screen_colors.detailsScreenColors
import com.movie_master.moviemaster.data.details_screen_data.details_screen_dimensions.DetailsScreenDimensions
import com.movie_master.moviemaster.data.details_screen_data.details_screen_states.detailsScreenStates
import com.movie_master.moviemaster.functionality.user_interface_operations.userInterfaceOperations

@Composable
        fun FullReviewDialog(
            modifier: Modifier = Modifier,
            colors: DetailsScreenColors = detailsScreenColors,
            dimensions: DetailsScreenDimensions = DetailsScreenDimensions()
        ) {

            if (detailsScreenStates.isReviewEnlarged) {
                Dialog(
                    onDismissRequest = { detailsScreenStates.isReviewEnlarged = false }
                ) {
                    Column(
                        modifier
                            .background(color = colors.detailsScreenBackGroundColor)
                            .width(dimensions.fullReviewDialogWidth.dp)
                            .height(dimensions.fullReviewDialogHeight.dp)
                            .padding(dimensions.reviewListItemPadding.dp),
                        verticalArrangement = Arrangement.spacedBy(dimensions.fullReviewDialogSpacing.dp)
                    ) {

                        // Review Author
                        FullReviewDialogHeaderItem(
                            categoryText = "Posted By:  ",
                            contentText = userInterfaceOperations.determineMediaReviewAuthor(
                                mediaItem = detailsScreenStates.selectedReview
                            )
                        )

                        // Review Post Date
                        FullReviewDialogHeaderItem(
                            categoryText = "Posted On:  ",
                            contentText = userInterfaceOperations.determineMediaReviewPostedDate(
                                mediaItem = detailsScreenStates.selectedReview
                            )
                        )

                        // Divider
                        Box(
                            modifier = Modifier
                                .background(color = colors.fullReviewDialogDividerColor)
                                .fillMaxWidth()
                                .height(dimensions.fullReviewDialogDividerHeight.dp)
                        )

                        LazyColumn(
                            modifier.weight(dimensions.fullReviewDialogReviewContentWeight),
                        ) {

                            // Review Content
                            item {
                                Text(
                                    text = userInterfaceOperations.determineMediaReviewContent(
                                        mediaItem = detailsScreenStates.selectedReview
                                    ),
                                    color = colors.detailsScreenFontAndIconColor,
                                    fontSize = dimensions.fullReviewDialogReviewContentFontSize.sp,
                                    letterSpacing = dimensions.detailsScreenCategoryLetterSpacing.sp
                            )
                            }
                        }

                        Box(
                            modifier
                                .fillMaxWidth()
                                .weight(dimensions.fullReviewDialogCloseButtonWeight),
                            contentAlignment = Alignment.CenterEnd){

                            // Close Button
                            Icon(
                                imageVector = Icons.Rounded.Clear,
                                contentDescription = null,
                                modifier
                                    .clickable { detailsScreenStates.isReviewEnlarged = false }
                                    .size(dimensions.fullReviewDialogCloseButtonSize.dp),
                                tint = colors.detailsScreenFontAndIconColor,
                            )
                        }

                    }
                }
            }

        }

@Composable
fun FullReviewDialogHeaderItem(
    modifier: Modifier = Modifier,
    dimensions: DetailsScreenDimensions = DetailsScreenDimensions(),
    colors: DetailsScreenColors = detailsScreenColors,
    categoryText: String,
    contentText: String,
) {

    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(
                fontSize = dimensions.fullReviewDialogHeaderCategoryFontSize.sp,
                fontWeight = FontWeight.Light
            )) {
                append(categoryText)
            }
            append(contentText)
        },
        modifier.basicMarquee(),
        color = colors.detailsScreenFontAndIconColor,
        fontSize = dimensions.fullReviewDialogHeaderContentFontSize.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = dimensions.detailsScreenCategoryLetterSpacing.sp
    )
}