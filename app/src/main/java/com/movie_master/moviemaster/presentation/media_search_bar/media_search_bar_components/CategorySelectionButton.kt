package com.movie_master.moviemaster.presentation.media_search_bar.media_search_bar_components

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_colors.MediaSearchBarColors
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_colors.mediaSearchBarColors
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_dimensions.MediaSearchBarDimensions
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_states.mediaSearchBarStates
import com.movie_master.moviemaster.functionality.api_operations.searchDataOperations
import com.movie_master.moviemaster.functionality.user_interface_operations.UserInterfaceOperations
import com.movie_master.moviemaster.functionality.user_interface_operations.userInterfaceOperations

// Composable That Allows Users To Select Categories That Display In The Data Search Bar
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun CategorySelectionButton(
    dimensions: MediaSearchBarDimensions = MediaSearchBarDimensions(),
    colors: MediaSearchBarColors = mediaSearchBarColors,
    operations: UserInterfaceOperations = userInterfaceOperations,
    modifier: Modifier,
    text: String,
    topStartCornerRadius: Dp = 0.dp,
    bottomStartCornerRadius: Dp = 0.dp,
    topEndCornerRadius: Dp = 0.dp,
    bottomEndCornerRadius: Dp = 0.dp,
) {

    val context = LocalContext.current

    // Category Selection Button Layout
    Box(
        modifier
            .selectable(
                selected = mediaSearchBarStates.selectedCategory == text,
                onClick = {
                    mediaSearchBarStates.selectedCategory = text
                searchDataOperations.manageDataSearch(context = context)}
            )
            .background(
                color = operations.determinedCategorySelectionButtonColors(
                    text = text,
                    selectedColor = colors.selectedCategorySelectionButtonColor,
                    unselectedColor = colors.unselectedCategorySelectionButtonColor
                ),
                shape = RoundedCornerShape(
                    topStart = topStartCornerRadius,
                    bottomStart = bottomStartCornerRadius,
                    topEnd = topEndCornerRadius,
                    bottomEnd = bottomEndCornerRadius)
            )
            .border(
                width = dimensions.categorySelectionBorderWidth.dp,
                color = operations.determinedCategorySelectionButtonColors(
                    text = text,
                    selectedColor = colors.selectedCategorySelectionButtonBorderColor,
                    unselectedColor = colors.unselectedCategorySelectionButtonBorderColor
                ),
                shape = RoundedCornerShape(
                    topStart = topStartCornerRadius,
                    bottomStart = bottomStartCornerRadius,
                    topEnd = topEndCornerRadius,
                    bottomEnd = bottomEndCornerRadius)
            )
            .fillMaxHeight(),
        contentAlignment = Alignment.Center

    ){

        // Category Selection Button Text
        Text(
            text = text,
            modifier.basicMarquee(),
            color = operations.determinedCategorySelectionButtonColors(
                text = text,
                selectedColor = colors.selectedCategorySelectionButtonTextColor,
                unselectedColor = colors.unselectedCategorySelectionButtonTextColor
            ),
            fontSize = dimensions.categorySelectionButtonFontSize.sp,
            fontWeight = FontWeight.SemiBold,
            )
    }
}