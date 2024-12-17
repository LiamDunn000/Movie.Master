package com.movie_master.moviemaster.presentation.details_screen.details_screen_components.standard_details_list

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.movie_master.moviemaster.data.details_screen_data.details_screen_colors.DetailsScreenColors
import com.movie_master.moviemaster.data.details_screen_data.details_screen_colors.detailsScreenColors
import com.movie_master.moviemaster.data.details_screen_data.details_screen_dimensions.DetailsScreenDimensions
import com.movie_master.moviemaster.functionality.api_operations.manageProfileOperations
import com.movie_master.moviemaster.functionality.navigation_operations.navigationOperations
import com.movie_master.moviemaster.functionality.user_interface_operations.UserInterfaceOperations
import com.movie_master.moviemaster.functionality.user_interface_operations.userInterfaceOperations

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun StandardDetailsListItem(
    modifier: Modifier = Modifier,
    dimensions: DetailsScreenDimensions = DetailsScreenDimensions(),
    colors: DetailsScreenColors = detailsScreenColors,
    operations: UserInterfaceOperations = userInterfaceOperations,
    navController: NavController,
    mediaItem: Any,
) {

    val context = LocalContext.current

    // Movie Selection List Item Frame
    Card(
        shape = RoundedCornerShape(dimensions.detailsScreenCategoryListItemCornerRadius),
        elevation = CardDefaults.cardElevation(dimensions.standardDetailsListItemElevation.dp),
    ) {

        // Movie Selection List Item Layout
        Column(
            modifier
                .pointerInput(mediaItem) {
                    detectTapGestures (
                        onTap = {
                            navigationOperations.navigateToDetailsScreen(
                                context = context,
                                navController = navController,
                                mediaItem = mediaItem
                            )
                        },
                        onLongPress = { manageProfileOperations.selectMediaToAddToList(mediaItem = mediaItem) },
                        onDoubleTap = {}
                    )

                }
                .width(dimensions.standardDetailsListItemWidth.dp)
                .fillMaxSize()
        ) {

            // Movie Selection List Item Image
            AsyncImage(
                model = operations.determineMediaImageUrl(mediaItem = mediaItem),
                contentDescription = null,
                modifier.height(dimensions.standardDetailsListItemImageHeight.dp),
                contentScale = ContentScale.FillBounds,
            )

            // Movie Selection List Item Info Section
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensions.standardDetailsListItemPadding.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                // Movie Selection List Item Title
                Text(
                    text = operations.determineMediaTitle(mediaItem = mediaItem),
                    modifier.basicMarquee(),
                    color = colors.detailsScreenReviewCardColor,
                    fontSize = dimensions.standardDetailsListItemTitleFontSize.sp,
                    fontWeight = FontWeight.SemiBold,
                )

            }
        }
    }
}