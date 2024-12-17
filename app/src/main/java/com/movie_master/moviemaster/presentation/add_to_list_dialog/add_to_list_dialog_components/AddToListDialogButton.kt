package com.movie_master.moviemaster.presentation.add_to_list_dialog.add_to_list_dialog_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movie_master.moviemaster.R
import com.movie_master.moviemaster.data.add_to_list_dialog_data.add_to_list_dialog_colors.AddToListDialogColors
import com.movie_master.moviemaster.data.add_to_list_dialog_data.add_to_list_dialog_dimensions.AddToListDialogDimensions

@Composable
fun AddToListDialogButton(
    modifier: Modifier = Modifier,
    dimensions: AddToListDialogDimensions = AddToListDialogDimensions(),
    actionType: String,
    listType: String,
    image: Int,
    onClick: () -> Unit) {

    Row(
        modifier
            .clickable { onClick() }
            .padding(dimensions.addToListDialogTextPadding.dp)
            .width(dimensions.addToListDialogWidth.dp),
        horizontalArrangement = Arrangement.spacedBy(dimensions.addToListDialogSpacing.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier.size(if (image == R.drawable.bookmark_icon) dimensions.addToListDialogIconSize.dp * 0.75f else dimensions.addToListDialogIconSize.dp),
            colorFilter = ColorFilter.tint(color = determineAddToListDialogButtonColor(actionType = actionType)),
        )

        Text(
            text = "$actionType $listType",
            modifier.basicMarquee(),
            color = determineAddToListDialogButtonColor(actionType = actionType),
            fontSize = dimensions.addToListDialogButtonFontSize.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = dimensions.addToListDialogLetterSpacing.sp
        )
    }
}

fun determineAddToListDialogButtonColor(actionType: String): Color {
    return if (actionType == "Add To") {
        AddToListDialogColors.addToListDialogTextAndIconColor
    } else {
        AddToListDialogColors.removeFromListTextAndIconColor
    }
}