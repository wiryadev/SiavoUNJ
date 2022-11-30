package com.wiryadev.siavounj.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.wiryadev.siavounj.R
import com.wiryadev.siavounj.ui.theme.Neutral600
import com.wiryadev.siavounj.ui.theme.SiavoUNJTheme
import com.wiryadev.siavounj.ui.theme.body2SemiBold
import com.wiryadev.siavounj.ui.theme.body3Medium

@Composable
fun AuthHeader(
    bodyText: String,
    modifier: Modifier = Modifier,
    hintText: String? = null,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth(),
    ) {
        AsyncImage(
            model = R.drawable.logo_unj,
            contentDescription = stringResource(R.string.logo_unj_desc),
            modifier = Modifier.size(size = 96.dp),
        )
        Spacer(modifier = Modifier.height(8.dp))
        AsyncImage(
            model = R.drawable.logo_siavo_landscape,
            contentDescription = stringResource(R.string.logo_unj_desc),
            modifier = Modifier.size(
                width = 192.dp,
                height = 96.dp,
            ),
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = bodyText,
            style = body2SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
        hintText?.let {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = bodyText,
                style = body3Medium.copy(
                    color = Neutral600,
                ),
            )
        }
    }
}

@Preview
@Composable
fun AuthHeaderPreview() {
    SiavoUNJTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface)
                .padding(16.dp)
        ) {
            AuthHeader(bodyText = "Silahkan login terlebih dahulu untuk mengakses!")
        }
    }
}