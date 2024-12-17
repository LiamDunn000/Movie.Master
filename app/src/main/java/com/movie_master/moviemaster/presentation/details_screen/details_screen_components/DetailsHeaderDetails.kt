package com.movie_master.moviemaster.presentation.details_screen.details_screen_components

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.movie_master.moviemaster.data.details_screen_data.details_screen_colors.DetailsScreenColors
import com.movie_master.moviemaster.data.details_screen_data.details_screen_colors.detailsScreenColors
import com.movie_master.moviemaster.data.details_screen_data.details_screen_dimensions.DetailsScreenDimensions
import com.movie_master.moviemaster.data.shared_data.sharedStates
import com.movie_master.moviemaster.functionality.api_operations.manageProfileOperations
import com.movie_master.moviemaster.functionality.user_interface_operations.userInterfaceOperations

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun DetailsHeaderDetails(
    dimensions: DetailsScreenDimensions = DetailsScreenDimensions(),
    colors: DetailsScreenColors = detailsScreenColors,

) {

    // Details Screen Header Details Frame
    ConstraintLayout(
        modifier = Modifier
            .zIndex(4f)
            .fillMaxSize()
    ) {

        // Constraint Name List
        val (title, image, details) = createRefs()

        // Details Screen Header Details Layout
        Row (
            modifier = Modifier
                .padding(
                    dimensions.detailScreenHeaderPadding.dp
                )
                .fillMaxWidth()
                .constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Details Screen Header Title
            Text(
                text = userInterfaceOperations.determineMediaTitle(mediaItem = sharedStates.selectedMediaItem),
                color = colors.detailsScreenFontAndIconColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = dimensions.detailsScreenHeaderTitleFontSize.sp,
                letterSpacing = dimensions.detailsScreenHeaderTitleLetterSpacing.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(dimensions.detailsScreenHeaderTitlePadding.dp)
                    .basicMarquee()
            )

            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = null,
                tint = colors.detailsScreenFontAndIconColor,
                modifier = Modifier
                    .clickable { manageProfileOperations.selectMediaToAddToList(mediaItem = sharedStates.selectedMediaItem) }
                    .weight(0.1f)
                    .size(dimensions.detailsScreenBackButtonSize.dp)
            )
        }

        // Details Screen Header Image Container
        Card(
            shape = RoundedCornerShape(dimensions.detailsScreenHeaderImageCornerRadius.dp),
            elevation = CardDefaults.cardElevation(dimensions.detailsScreenHeaderImageElevation.dp),
            modifier = Modifier
                .size(dimensions.detailsScreenHeaderImageSize.dp)
                .aspectRatio(11f / 16f)
                .constrainAs(image) {
                    top.linkTo(title.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(
                        parent.start,
                        margin = dimensions.detailsScreenHeaderImageStartMargin.dp
                    )
                }

        ) {

            // Details Screen Header Image
            AsyncImage(
                model = userInterfaceOperations.determineMediaImageUrl(
                    mediaItem = sharedStates.selectedMediaItem,
                    format = ".svg"),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )

        }

        // Details Screen Header Info Panel
        DetailsScreenHeaderInfoPanel(
            modifier = Modifier
                .constrainAs(details) {
                    bottom.linkTo(parent.bottom, margin = dimensions.detailsScreenHeaderInfoPanelBottomMargin.dp)
                    end.linkTo(parent.end, margin = dimensions.detailsScreenHeaderInfoPanelEndMargin.dp)
                }
        )
}}