package com.wiryadev.siavounj.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.wiryadev.siavounj.R
import com.wiryadev.siavounj.ui.theme.Neutral500

@Composable
fun UserProfilePicture(
    size: Dp,
    modifier: Modifier = Modifier,
    borderWidth: Dp = 1.dp,
) {
    SubcomposeAsyncImage(
        model = R.drawable.fake_profile_pic,
        contentDescription = stringResource(R.string.user_profile_picture),
        loading = { CircularProgressIndicator() },
        contentScale = ContentScale.FillBounds,
        modifier = modifier
            .size(size = size)
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
            .border(
                width = borderWidth,
                color = Neutral500,
                shape = CircleShape,
            ),
    )
}