package com.movie_master.moviemaster.presentation.profile_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movie_master.moviemaster.data.profile_screen_data.profile_screen_colors.ProfileScreenColors
import com.movie_master.moviemaster.data.profile_screen_data.profile_screen_dimensions.ProfileScreenDimensions
import com.movie_master.moviemaster.data.profile_screen_data.profile_screen_states.profileScreenStates
import com.movie_master.moviemaster.functionality.api_operations.ManageProfileOperations
import com.movie_master.moviemaster.functionality.api_operations.manageProfileOperations

@Composable
fun LoginButton(
    dimensions: ProfileScreenDimensions = ProfileScreenDimensions(),
    colors: ProfileScreenColors.Companion = ProfileScreenColors.Companion,
    operations: ManageProfileOperations = manageProfileOperations,
) {

    val context = LocalContext.current

    // Log In Button Layout
    Box (
        modifier = Modifier
            .clickable { operations.manageLoginButtonOnClickStates(context = context) }
            .background(
                color = colors.loginScreenButtonColor,
                shape = RoundedCornerShape(dimensions.loginButtonCornerRadius.dp)
            )
            .width(dimensions.loginButtonWidth.dp)
            .height(dimensions.loginButtonHeight.dp),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = if (profileScreenStates.isUserLoggedOut) {
                "Log In"
            } else {
                "Log Out"
            },
            color = colors.profileScreenFontAndIconColor,
            fontSize = dimensions.loginButtonFontSize.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}