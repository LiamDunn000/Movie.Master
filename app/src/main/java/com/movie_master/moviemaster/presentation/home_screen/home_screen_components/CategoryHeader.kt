package com.movie_master.moviemaster.presentation.home_screen.home_screen_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.movie_master.moviemaster.data.home_screen_data.home_screen_colors.HomeScreenColors
import com.movie_master.moviemaster.data.home_screen_data.home_screen_colors.homeScreenColors
import com.movie_master.moviemaster.data.home_screen_data.home_screen_data_dimensions.HomeScreenDimensions

@Composable
fun CategoryHeader(
    modifier: Modifier = Modifier,
    dimensions: HomeScreenDimensions = HomeScreenDimensions(),
    colors: HomeScreenColors = homeScreenColors,
    category: String
) {

    // Category Header Layout
    Row(
        modifier
            .padding(vertical = dimensions.homeScreenPadding.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimensions.categoryHeaderSpacing.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Category Header Text
        Text(
            text = category,
            color = colors.categoryHeaderTextColor,
            fontSize = dimensions.categoryHeaderFontSize.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = dimensions.categoryHeaderLetterSpacing.sp
        )

        // Category Header Divider
        Box(
            modifier
                .background(color = colors.categoryHeaderDividerColor)
                .fillMaxWidth()
                .height(dimensions.categoryHeaderDividerHeight.dp)
        )
    }
}