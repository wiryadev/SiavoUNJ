package com.wiryadev.siavounj.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.wiryadev.siavounj.R
import com.wiryadev.siavounj.ui.theme.JoustBlue500
import com.wiryadev.siavounj.ui.theme.Neutral800
import com.wiryadev.siavounj.ui.theme.body1Bold
import com.wiryadev.siavounj.ui.theme.body3
import com.wiryadev.siavounj.ui.theme.body3Medium

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LatestInfoItem(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    onInfoClick: () -> Unit,
) {
    val titleSplit = title.split(" ")
    val titleFormatted = buildString {
        append(titleSplit[0])
        append("\n")
        for (i in 1 until titleSplit.size) {
            append(titleSplit[i])
            append(" ")
        }
    }
    Card(
        onClick = onInfoClick,
        backgroundColor = Color.Red,
        modifier = modifier
            .width(300.dp)
            .height(160.dp),
    ) {
        Box(
            modifier = Modifier
                .background(color = JoustBlue500)
        ) {
            AsyncImage(
                model = R.drawable.ic_latest_info,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(128.dp),
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(all = 16.dp),
            ) {
                Text(
                    text = titleFormatted,
                    style = body1Bold,
                    color = Color.White,
                    maxLines = 2,
                )
                Text(
                    text = subtitle,
                    style = body3,
                    fontStyle = FontStyle.Italic,
                    color = Color.White,
                    maxLines = 2,
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(vertical = 12.dp),
            ) {
                Text(
                    text = stringResource(R.string.see_detail),
                    style = body3Medium,
                    color = Neutral800,
                )
            }
        }
    }
}