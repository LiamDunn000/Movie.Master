package com.movie_master.moviemaster.presentation.media_search_bar.media_search_bar_components

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_colors.MediaSearchBarColors
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_colors.mediaSearchBarColors
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_dimensions.MediaSearchBarDimensions
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_states.MediaSearchBarStates
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_states.mediaSearchBarStates
import com.movie_master.moviemaster.functionality.api_operations.SearchDataOperations
import com.movie_master.moviemaster.functionality.api_operations.searchDataOperations
import com.movie_master.moviemaster.functionality.navigation_operations.navigationOperations

// Text Field That Contains The Text That Queries The API Data
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun MediaSearchBarTextField(
    dimensions: MediaSearchBarDimensions = MediaSearchBarDimensions(),
    colors: MediaSearchBarColors = mediaSearchBarColors,
    states: MediaSearchBarStates = mediaSearchBarStates,
    operations: SearchDataOperations = searchDataOperations,
    navController: NavController
    ) {

    // Variable That Stores The Context
    val context = LocalContext.current

    // Variable That Controls Text Field Focus
    val focusManager = LocalFocusManager.current

    // Function That Toggles The Size Of The Media Search Bar Based On The Focus Of The Text Field
    operations.toggleMediaSearchBarSizeBasedOnFocus(focusManager = focusManager)

    // Media Search Bar Text Field
    TextField(
        value = states.mediaSearchBarTextFieldValue,
        onValueChange = {
            states.mediaSearchBarTextFieldValue = it
            operations.manageDataSearch(context = context)
            operations.toggleMediaSearchBarSizeBasedOnTextFieldValue()
        },
        modifier = Modifier
            .padding(
                top = dimensions.dataSearchBarTextFieldExternalPadding.dp,
                start = dimensions.dataSearchBarTextFieldExternalPadding.dp,
                end = dimensions.dataSearchBarTextFieldExternalPadding.dp
            )
            .height(dimensions.dataSearchBarTextFieldHeight.dp)
            .border(
                color = colors.dataSearchBarTextFieldBorderColor,
                shape = RoundedCornerShape(dimensions.dataSearchBarTextFieldCornerRadius),
                width = dimensions.dataSearchBarTextFieldBorderWidth.dp,
            )
            .fillMaxWidth()
            .padding(horizontal = dimensions.dataSearchBarTextFieldInternalPadding.dp)
            .focusRequester(states.mediaSearchBarTextFieldFocusRequester)
            .onFocusChanged { onFocus ->
                states.isMediaSearchBarTextFieldFocused = onFocus.isFocused
            },

        // Media Search Bar Text Field Colors
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colors.dataSearchBarTextFieldContainerColor,
            unfocusedContainerColor = colors.dataSearchBarTextFieldContainerColor,
            cursorColor = colors.dataSearchBarTextFieldCursorColor,
            focusedIndicatorColor = colors.dataSearchBarTextFieldIndicatorColor,
            unfocusedIndicatorColor = colors.dataSearchBarTextFieldIndicatorColor
        ),

        shape = RoundedCornerShape(dimensions.dataSearchBarTextFieldCornerRadius),
        singleLine = true,

        // Media Search Bar Text Field Leading Icon
        leadingIcon = {
            Icon(
                Icons.Rounded.Search,
                contentDescription = null,
                tint = colors.dataSearchBarTextFieldIconColor,
                modifier = Modifier.size(dimensions.dataSearchBarTextFieldIconSize.dp)
            )
        },

        trailingIcon = {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = null,
                tint = colors.dataSearchBarTextFieldIconColor,
                modifier = Modifier
                    .clickable { navigationOperations.navigateBack(context = context, navController = navController) }
                    .size(dimensions.dataSearchBarTextFieldIconSize.dp / 1.2f)
            )
        },

        // Media Search Bar Text Field Text Style
        textStyle = TextStyle(
            color = colors.dataSearchBarTextFieldTextColor,
            fontSize = dimensions.dataSearchBarTextFieldFontSize.sp,
            fontWeight = FontWeight.SemiBold
        )
    )
}
