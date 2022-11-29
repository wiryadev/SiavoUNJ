package com.wiryadev.siavounj.ui.screens.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wiryadev.siavounj.R
import com.wiryadev.siavounj.ui.theme.*

@Composable
fun NotificationScreen(
    modifier: Modifier = Modifier,
) {

}

@Composable
fun NotificationAppBar(
    notificationsAmount: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            text = "SIAVO UNJ",
            style = body1SemiBold,
            color = Debutante600,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Row {
                Text(
                    text = "SIAVO UNJ",
                    style = body2Bold,
                    color = Debutante600,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(24.dp))
                        .background(Debutante500)
                        .padding(
                            vertical = 2.dp,
                            horizontal = 8.dp,
                        ),
                ) {
                    Text(
                        text = notificationsAmount.toString(),
                        style = body3,
                        color = Color.White,
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_double_check),
                    contentDescription = null,
                    tint = Debutante500,
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = stringResource(R.string.mark_as_read),
                    style = body3Medium,
                    color = Debutante500,
                )
            }
        }
    }
}

@Preview
@Composable
fun NotificationAppBarPreview() {
    SiavoUNJTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(vertical = 16.dp),
        ) {
            NotificationAppBar(notificationsAmount = 25)
        }
    }
}