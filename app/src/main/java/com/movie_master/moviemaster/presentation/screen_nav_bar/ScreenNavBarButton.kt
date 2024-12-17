package com.movie_master.moviemaster.presentation.screen_nav_bar

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.movie_master.moviemaster.data.screen_nav_bar_data.screen_nav_bar_colors.ScreenNavBarColors
import com.movie_master.moviemaster.data.screen_nav_bar_data.screen_nav_bar_colors.screenNavBarColors
import com.movie_master.moviemaster.data.screen_nav_bar_data.screen_nav_bar_dimensions.ScreenNavBarDimensions
import com.movie_master.moviemaster.data.screen_nav_bar_data.screen_nav_bar_states.ScreenNavBarStates
import com.movie_master.moviemaster.data.screen_nav_bar_data.screen_nav_bar_states.screenNavBarStates
import com.movie_master.moviemaster.data.shared_data.sharedStates
import com.movie_master.moviemaster.functionality.navigation_operations.navigationOperations
import com.movie_master.moviemaster.functionality.user_interface_operations.userInterfaceOperations

@Composable
fun ScreenNavBarButton(
    modifier: Modifier = Modifier,
    dimensions: ScreenNavBarDimensions = ScreenNavBarDimensions(),
    colors: ScreenNavBarColors = screenNavBarColors,
    states: ScreenNavBarStates = screenNavBarStates,
    navController: NavController,
    icon: ImageVector,
    text: String,
    topStartCornerRadius: Dp = 0.dp,
    bottomStartCornerRadius: Dp = 0.dp,
    topEndCornerRadius: Dp = 0.dp,
    bottomEndCornerRadius: Dp = 0.dp
) {

    // Screen NavBar Button Layout
    Column(
        modifier
            .selectable(
                selected = states.selectedScreen == text,
                onClick = {
                    states.selectedScreen = text
                    navigationOperations.determineScreenNavBarButtonNavigation(navController = navController) }
            )
            .background(color = userInterfaceOperations.determineScreenNavBarButtonColors(text = text),
                shape = RoundedCornerShape(
                    topStart = topStartCornerRadius,
                    bottomStart = bottomStartCornerRadius,
                    topEnd = topEndCornerRadius,
                    bottomEnd = bottomEndCornerRadius
                )
            )
            .height(dimensions.screenNavBarButtonHeight.dp)
            .padding(dimensions.screenNavBarButtonPadding.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier.size(dimensions.screenNavBarButtonIconSize.dp),
            tint = colors.screenNavBarFontAndIconColor
        )

        Text(
            text = text,
            color = colors.screenNavBarFontAndIconColor,
            fontSize = dimensions.screenNavBarButtonFontSize.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = dimensions.screenNavBarButtonLetterSpacing.sp
        )
    }
}