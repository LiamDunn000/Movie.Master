package com.movie_master.moviemaster.presentation.media_search_bar

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_colors.MediaSearchBarColors
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_colors.mediaSearchBarColors
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_dimensions.MediaSearchBarDimensions
import com.movie_master.moviemaster.functionality.api_operations.searchDataOperations
import com.movie_master.moviemaster.presentation.media_search_bar.media_search_bar_components.CategorySelectionPanel
import com.movie_master.moviemaster.presentation.media_search_bar.media_search_bar_components.MediaSearchBarTextField
import com.movie_master.moviemaster.presentation.media_search_bar.media_search_bar_components.SearchResultList

// Composable That Allows User To Search For Movies, TV Shows, and Celebrities
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun MediaSearchBar(
    dimensions: MediaSearchBarDimensions = MediaSearchBarDimensions(),
    colors: MediaSearchBarColors = mediaSearchBarColors,
    navController: NavController) {

    // Variable That Animates The Size Of The Media Search Bar
    val mediaSearchBarHeight = animateDpAsState(
        targetValue = searchDataOperations.animateMediaSearchBarSize(dimensions = dimensions), label = ""
    ).value

        Card(
            shape = RectangleShape,
            elevation = CardDefaults.cardElevation(dimensions.mediaSearchBarElevation.dp),
            colors = CardDefaults.cardColors(colors.mediaSearchBarBackgroundColor)
        ) {

            // Media Search Bar Layout
            Column(
                modifier = Modifier
                    .background(color = colors.mediaSearchBarBackgroundColor)
                    .fillMaxWidth()
                    .height(mediaSearchBarHeight),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(dimensions.mediaSearchBarSpacing.dp)
            ) {

                // Media Search Bar Text Field
                MediaSearchBarTextField(navController = navController)

                // Data Type Selection Panel
                CategorySelectionPanel()

                // Search Result List
                SearchResultList(navController = navController)
            }
        }
}