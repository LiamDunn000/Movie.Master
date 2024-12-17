package com.movie_master.moviemaster.presentation.details_screen.details_screen_components.details_screen_header.review_list

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movie_master.moviemaster.data.details_screen_data.details_screen_colors.DetailsScreenColors
import com.movie_master.moviemaster.data.details_screen_data.details_screen_colors.detailsScreenColors
import com.movie_master.moviemaster.data.details_screen_data.details_screen_dimensions.DetailsScreenDimensions
import com.movie_master.moviemaster.data.details_screen_data.details_screen_states.detailsScreenStates
import com.movie_master.moviemaster.functionality.user_interface_operations.userInterfaceOperations
import com.movie_master.moviemaster.presentation.details_screen.details_screen_components.details_screen_header.FullReviewDialog

@Composable
fun ReviewListItem(
    modifier: Modifier = Modifier,
    dimensions: DetailsScreenDimensions = DetailsScreenDimensions(),
    colors: DetailsScreenColors = detailsScreenColors,
    mediaItem: Any,
) {

    FullReviewDialog()

    // Review List Item Container
    Card(
        modifier.clickable {
            detailsScreenStates.isReviewEnlarged = true
            detailsScreenStates.selectedReview = mediaItem
        },
        elevation = CardDefaults.cardElevation(10.dp),
    ) {

        // Review List Item Layout
        Column(
            modifier.size(dimensions.reviewListItemSize.dp),
        ) {

            LazyColumn(
                modifier
                    .background(color = colors.detailsScreenReviewCardColor)
                    .fillMaxWidth()
                    .fillMaxHeight(0.865f)
            ) {

                // Review List Item Content
                item {
                    Text(
                        text = userInterfaceOperations.determineMediaReviewContent(mediaItem = mediaItem),
                        modifier.padding(dimensions.reviewListItemPadding.dp),
                        color = colors.detailsScreenFontAndIconColor,
                        fontSize = dimensions.reviewContentFontSize.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = dimensions.detailsScreenCategoryLetterSpacing.sp
                    )
                }
            }

            // Review List Item Author
            Text(
                text = userInterfaceOperations.determineMediaReviewAuthor(mediaItem = mediaItem),
                modifier
                    .padding(dimensions.reviewAuthorPadding.dp)
                    .basicMarquee(),
                color = colors.detailsScreenReviewCardColor,
                fontSize = dimensions.reviewAuthorFontSize.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}