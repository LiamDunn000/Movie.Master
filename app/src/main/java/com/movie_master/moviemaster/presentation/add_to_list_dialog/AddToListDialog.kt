package com.movie_master.moviemaster.presentation.add_to_list_dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.movie_master.moviemaster.R
import com.movie_master.moviemaster.data.add_to_list_dialog_data.add_to_list_dialog_colors.AddToListDialogColors
import com.movie_master.moviemaster.data.add_to_list_dialog_data.add_to_list_dialog_dimensions.AddToListDialogDimensions
import com.movie_master.moviemaster.data.add_to_list_dialog_data.add_to_list_dialog_states.AddToListDialogStates
import com.movie_master.moviemaster.data.profile_screen_data.profile_screen_states.profileScreenStates
import com.movie_master.moviemaster.functionality.api_operations.ManageProfileOperations
import com.movie_master.moviemaster.functionality.api_operations.manageProfileOperations
import com.movie_master.moviemaster.presentation.add_to_list_dialog.add_to_list_dialog_components.AddToListDialogButton

@Composable
fun AddToListDialog(
    modifier: Modifier = Modifier,
    dimensions: AddToListDialogDimensions = AddToListDialogDimensions(),
    colors: AddToListDialogColors.Companion = AddToListDialogColors.Companion,
    operations: ManageProfileOperations = manageProfileOperations) {

    val context = LocalContext.current

    if (AddToListDialogStates.isAddToListDialogVisible) {

        // Add To List Dialog Container
        Dialog(onDismissRequest = { AddToListDialogStates.isAddToListDialogVisible = false }) {

            // Add To List Dialog Layout
            Column(
                modifier = Modifier
                    .background(
                        color = colors.addToListDialogBackgroundColor,
                        shape = RoundedCornerShape(20.dp),
                    )
                    .wrapContentWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                if (profileScreenStates.userDetails.id == 0) {
                    Text(
                        text = "Login To Add To List",
                        modifier.padding(dimensions.addToListDialogTextPadding.dp),
                        color = colors.addToListDialogTextAndIconColor,
                        fontSize = dimensions.addToListDialogDefaultFontSize.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = dimensions.addToListDialogLetterSpacing.sp
                    )
                } else {

                    // Add Or Remove From Watchlist Button
                    AddToListDialogButton(
                        actionType = operations.determineAddToListDialogButtonActionText(
                            listOne = profileScreenStates.moviesOnWatchList.results,
                            listTwo = profileScreenStates.tvSeriesOnWatchList.results
                        ),

                        listType = "Watchlist",
                        image = R.drawable.bookmark_icon,
                        onClick = {
                            operations.manageAddToListDialogButtonOnClickState(
                                listOne = profileScreenStates.moviesOnWatchList.results,
                                listTwo = profileScreenStates.tvSeriesOnWatchList.results,
                                removeFunction = { manageProfileOperations.addOrRemoveFromWatchList(context = context, result = "false") },
                                addFunction = { manageProfileOperations.addOrRemoveFromWatchList(context = context, result = "true") }
                            )
                        }
                    )

                    // Add Or Remove From Favorites Button
                    AddToListDialogButton(
                        actionType = operations.determineAddToListDialogButtonActionText(
                            listOne = profileScreenStates.favoriteMoviesList.results,
                            listTwo = profileScreenStates.favoriteTvSeriesList.results
                        ),
                        listType = "Favorites",
                        image = R.drawable.heart_icon,
                        onClick = {
                            operations.manageAddToListDialogButtonOnClickState(
                                listOne = profileScreenStates.favoriteMoviesList.results,
                                listTwo = profileScreenStates.favoriteTvSeriesList.results,
                                removeFunction = { manageProfileOperations.addOrRemoveFromFavoritesList(context = context, result = "false") },
                                addFunction = { manageProfileOperations.addOrRemoveFromFavoritesList(context = context, result = "true") }
                            )
                        }
                    )
                }
            }
        }
    }

}


