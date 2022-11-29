package com.wiryadev.siavounj.ui.screens.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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
import com.wiryadev.siavounj.data.model.previewNotificationPreview
import com.wiryadev.siavounj.ui.components.NotificationPreviewItem
import com.wiryadev.siavounj.ui.theme.Debutante500
import com.wiryadev.siavounj.ui.theme.Debutante600
import com.wiryadev.siavounj.ui.theme.SiavoUNJTheme
import com.wiryadev.siavounj.ui.theme.body1SemiBold
import com.wiryadev.siavounj.ui.theme.body2Bold
import com.wiryadev.siavounj.ui.theme.body3
import com.wiryadev.siavounj.ui.theme.body3Medium

@Composable
fun NotificationScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        NotificationAppBar(
            notificationsAmount = previewNotificationPreview.size,
        )
        LazyColumn {
            items(previewNotificationPreview) { item ->
                NotificationPreviewItem(
                    title = item.title,
                    dateTime = item.dateTime,
                    isRead = item.isRead,
                )
                Divider()
            }
        }
    }
}

@Composable
fun NotificationAppBar(
    notificationsAmount: Int,
    modifier: Modifier = Modifier,
) {
    val badgeHorizontalPadding by remember {
        derivedStateOf {
            if (notificationsAmount > 9) 8 else 12
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp),
    ) {
        Text(
            text = "SIAVO UNJ",
            style = body1SemiBold,
            color = Debutante600,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 24.dp,
                    bottom = 16.dp,
                ),
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Row {
                Text(
                    text = stringResource(R.string.my_notifications),
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
                            horizontal = badgeHorizontalPadding.dp,
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