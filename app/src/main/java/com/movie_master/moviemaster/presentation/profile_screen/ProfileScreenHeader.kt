package com.movie_master.moviemaster.presentation.profile_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.movie_master.moviemaster.R
import com.movie_master.moviemaster.data.profile_screen_data.profile_screen_colors.ProfileScreenColors
import com.movie_master.moviemaster.data.profile_screen_data.profile_screen_dimensions.ProfileScreenDimensions
import com.movie_master.moviemaster.data.profile_screen_data.profile_screen_states.profileScreenStates
import com.movie_master.moviemaster.functionality.api_operations.ManageProfileOperations
import com.movie_master.moviemaster.functionality.api_operations.manageProfileOperations

@Composable
fun ProfileScreenHeader(
    modifier: Modifier = Modifier,
    dimensions: ProfileScreenDimensions = ProfileScreenDimensions(),
    colors: ProfileScreenColors.Companion = ProfileScreenColors.Companion,
    operations: ManageProfileOperations = manageProfileOperations
) {

    val context = LocalContext.current

    operations.goToLoginPage(context = context)

    // Profile Screen Header Layout
    Row(
        modifier
            .background(color = colors.profileScreenBackgroundColor)
            .fillMaxWidth()
            .height(dimensions.profileScreenHeaderHeight.dp)
            .padding(horizontal = dimensions.profileScreenHeaderPadding.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Profile Image Container
        Box(
            modifier
                .clip(shape = CircleShape)
                .size(dimensions.profileImageSize.dp),
            contentAlignment = Alignment.Center
        ) {

            // Conditional That Determines Profile Image
            if (!profileScreenStates.isUserLoggedOut) {

                // Profile Image
                AsyncImage(
                    model = "https://image.tmdb.org/t/p/w500${profileScreenStates.userDetails.avatar.tmdb.avatar_path}.svg",
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )} else {

                    // Profile Image Placeholder
                    Image(
                        painter = painterResource(id = R.drawable.age_rating_icon),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        colorFilter = ColorFilter.tint(color = colors.profileScreenFontAndIconColor),
                        )
                }
        }

        // User Name
        Text(
            text = if (profileScreenStates.isUserLoggedOut)
                "Log In To View" else profileScreenStates.userDetails.username,
            modifier
                .weight(dimensions.userNameWeight)
                .padding(dimensions.profileScreenHeaderPadding.dp),
            color = colors.profileScreenFontAndIconColor,
            fontSize = dimensions.userNameFontSize.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)

        // Login Button
        LoginButton()

    }
}