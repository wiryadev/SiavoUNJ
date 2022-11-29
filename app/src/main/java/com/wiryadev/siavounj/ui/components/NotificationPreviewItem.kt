package com.wiryadev.siavounj.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wiryadev.siavounj.data.model.previewNotificationPreview
import com.wiryadev.siavounj.ui.theme.*

@Composable
fun NotificationPreviewItem(
    title: String,
    dateTime: String,
    isRead: Boolean,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
            .background(
                color = if (isRead) Debutante100 else Color.White,
            )
            .fillMaxWidth()
            .padding(
                vertical = 12.dp,
                horizontal = 16.dp,
            ),
    ) {
        Text(
            text = title,
            style = body2Medium,
            color = Neutral900,
        )
        Text(
            text = dateTime,
            style = body3,
            color = Neutral700,
        )
    }
}

@Preview
@Composable
fun NotificationPreviewItemPreview() {
    SiavoUNJTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(vertical = 16.dp),
        ) {
            NotificationPreviewItem(
                title = previewNotificationPreview.first().title,
                dateTime = previewNotificationPreview.first().dateTime,
                isRead = previewNotificationPreview.first().isRead,
            )
        }
    }
}