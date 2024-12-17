package com.movie_master.moviemaster.presentation.details_screen.details_screen_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movie_master.moviemaster.data.details_screen_data.details_screen_colors.DetailsScreenColors
import com.movie_master.moviemaster.data.details_screen_data.details_screen_colors.detailsScreenColors
import com.movie_master.moviemaster.data.details_screen_data.details_screen_dimensions.DetailsScreenDimensions

@Composable
fun DetailsScreenCategoryHeader(
    modifier: Modifier = Modifier,
    dimensions: DetailsScreenDimensions = DetailsScreenDimensions(),
    colors: DetailsScreenColors = detailsScreenColors,
    icon: Int,
    text: String
) {

    Row(
        modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimensions.detailsScreenListSpacing.dp)
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier.size(dimensions.detailsScreenCategoryHeaderIconSize.dp),
            colorFilter = ColorFilter.tint(colors.detailsScreenFontAndIconColor),


            )

        Text(
            text = text,
            color = colors.detailsScreenFontAndIconColor,
            fontSize = dimensions.detailsScreenCategoryHeaderFontSize.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = dimensions.detailsScreenCategoryLetterSpacing.sp
        )
    }
}