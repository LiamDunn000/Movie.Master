package com.movie_master.moviemaster.presentation.details_screen

import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.movie_master.moviemaster.data.details_screen_data.details_screen_colors.detailsScreenColors
import com.movie_master.moviemaster.data.details_screen_data.details_screen_dimensions.DetailsScreenDimensions
import com.movie_master.moviemaster.data.shared_data.sharedStates
import com.movie_master.moviemaster.functionality.navigation_operations.navigationOperations
import com.movie_master.moviemaster.functionality.user_interface_operations.userInterfaceOperations
import com.movie_master.moviemaster.presentation.details_screen.details_screen_components.DetailsScreenSummary
import com.movie_master.moviemaster.presentation.details_screen.details_screen_components.DetailsScreenHeader
import com.movie_master.moviemaster.presentation.details_screen.details_screen_components.image_list.EnlargedImageDialog
import com.movie_master.moviemaster.presentation.details_screen.details_screen_components.image_list.ImageList
import com.movie_master.moviemaster.presentation.details_screen.details_screen_components.review_list.ReviewList
import com.movie_master.moviemaster.presentation.details_screen.details_screen_components.standard_details_list.CreditsList
import com.movie_master.moviemaster.presentation.details_screen.details_screen_components.standard_details_list.SimilarMediaList
import com.movie_master.moviemaster.presentation.media_search_bar.MediaSearchBar

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    dimensions: DetailsScreenDimensions = DetailsScreenDimensions(),
    navController: NavController) {

    val context = LocalContext.current

    BackHandler {
        navigationOperations.navigateBack(context = context, navController = navController);
        userInterfaceOperations.determineMediaDetails(
            context = context,
            mediaItem = sharedStates.selectedMediaItem) }

    EnlargedImageDialog()

    Scaffold(
        modifier.padding(WindowInsets.systemBars.asPaddingValues()),
        topBar = { MediaSearchBar(navController = navController) }
    ) {padding ->
        LazyColumn(
            modifier
                .background(color = detailsScreenColors.detailsScreenBackGroundColor)
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(dimensions.detailsScreenSpacing.dp)
        ) {

            // Details Screen Category Header
            item { DetailsScreenHeader() }

            // Details Screen Summary
            item { DetailsScreenSummary() }

            // Details Screen Credits List
            item { CreditsList(navController = navController) }

            // Details Screen Image List
            item { ImageList() }

            // Details Screen Review List
            item { ReviewList() }

            item { SimilarMediaList(navController = navController) }
        }
    }
}