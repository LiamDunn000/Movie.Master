package com.movie_master.moviemaster.data.shared_data

import androidx.compose.ui.graphics.Color

val colors = Colors()

class Colors {

    // Transparent
    val transparent = Color(0x00000000)

    // White
    val white = Color(0xffffffff)

    // Black
    val black50Percent = Color(0xff000000).copy(alpha = 0.5F)

    // Dark White
    val darkWhite80Percent = Color(0xffE4E4E4).copy(alpha = 0.80F)
    val darkWhite25Percent = Color(0xffE4E4E4).copy(alpha = 0.25F)
    val darkWhite50Percent = Color(0xffE4E4E4).copy(alpha = 0.50F)

    // Dark Blue
    val darkBlue = Color(0xff11192e)
    val lightDarkBlue = Color(0xff16213e)

    // Yellow
    val yellow = Color(0xffeeff00)

    // Red
    val red = Color(0xffff0000)
    val lightRed = Color(0xffff5959)


    // Cyan
    val cyan = Color(0xff00ffff)
    val cyan70Percent = Color(0xff00ffff).copy(alpha = 0.70F)
}