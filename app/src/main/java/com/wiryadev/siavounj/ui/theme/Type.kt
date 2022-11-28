package com.wiryadev.siavounj.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.wiryadev.siavounj.R

val PoppinsFamily = FontFamily(
    listOf(
        Font(R.font.poppins_regular),
        Font(R.font.poppins_medium, FontWeight.Medium),
        Font(R.font.poppins_semibold, FontWeight.SemiBold),
        Font(R.font.poppins_bold, FontWeight.Bold)
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = PoppinsFamily,
    button = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)


val title1: TextStyle
    @Composable get() = MaterialTheme.typography.h4.copy(
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
    )

val title2: TextStyle
    @Composable get() = MaterialTheme.typography.h4.copy(
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
    )

val body1: TextStyle
    @Composable get() = MaterialTheme.typography.body1.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
    )

val body1Medium: TextStyle
    @Composable get() = MaterialTheme.typography.body1.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
    )

val body1SemiBold: TextStyle
    @Composable get() = MaterialTheme.typography.body1.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
    )

val body2: TextStyle
    @Composable get() = MaterialTheme.typography.body1.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
    )


val body2Medium: TextStyle
    @Composable get() = MaterialTheme.typography.body1.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
    )

val body2Bold: TextStyle
    @Composable get() = MaterialTheme.typography.body1.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
    )

val body2Link: TextStyle
    @Composable get() = MaterialTheme.typography.body1.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        textDecoration = TextDecoration.Underline,
    )

val body3: TextStyle
    @Composable get() = MaterialTheme.typography.body1.copy(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
    )

val body3Medium: TextStyle
    @Composable get() = MaterialTheme.typography.body1.copy(
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
    )

val body3Bold: TextStyle
    @Composable get() = MaterialTheme.typography.body1.copy(
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
    )