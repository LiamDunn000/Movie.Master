package com.movie_master.moviemaster.presentation.profile_screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.movie_master.moviemaster.data.profile_screen_data.profile_screen_colors.ProfileScreenColors
import com.movie_master.moviemaster.data.profile_screen_data.profile_screen_dimensions.ProfileScreenDimensions

@Composable
fun ProfileScreenListPlaceholderText(
    listType: String,
    conditionalType: String,
) {
    Text(
        text = if (conditionalType == "Login") {
            "Login To View $listType"
        } else {
            "Nothing Saved To $listType"
        },
        color = ProfileScreenColors.profileScreenFontAndIconColor,
        fontSize = ProfileScreenDimensions().profileScreenListPlaceHolderTextFontSize.sp
    )
}