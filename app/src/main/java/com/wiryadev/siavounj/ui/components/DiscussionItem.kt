package com.wiryadev.siavounj.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wiryadev.siavounj.R
import com.wiryadev.siavounj.ui.theme.Debutante600
import com.wiryadev.siavounj.ui.theme.Neutral600
import com.wiryadev.siavounj.ui.theme.Neutral700
import com.wiryadev.siavounj.ui.theme.Neutral800
import com.wiryadev.siavounj.ui.theme.SiavoUNJTheme
import com.wiryadev.siavounj.ui.theme.body2Medium
import com.wiryadev.siavounj.ui.theme.body3
import com.wiryadev.siavounj.ui.theme.body3Medium

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DiscussionPreviewItem(
    id: String,
    title: String,
    lastDiscussion: String,
    latestUpdate: String,
    totalUserInvolved: Int,
    totalDiscussionBubble: Int,
    modifier: Modifier = Modifier,
    onDiscussionClick: (String) -> Unit,
) {
    Card(
        elevation = 4.dp,
        onClick = { onDiscussionClick(id) },
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = title,
                    style = body2Medium,
                    color = Debutante600,
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_three_dots_vertical),
                    contentDescription = null,
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp),
            ) {
                Text(
                    text = stringResource(R.string.last_discussion),
                    style = body3Medium.copy(
                        fontSize = 11.sp,
                    ),
                    color = Neutral600,
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    UserProfilePicture(size = 24.dp)
                    Text(
                        text = lastDiscussion,
                        style = body3.copy(
                            fontSize = 11.sp,
                        ),
                        color = Neutral800,
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Row {
                    Text(
                        text = stringResource(R.string.latest_update),
                        style = body3Medium.copy(
                            fontSize = 11.sp,
                        ),
                        color = Neutral800,
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = latestUpdate,
                        style = body3.copy(
                            fontSize = 11.sp,
                        ),
                        color = Neutral700,
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    DiscussionPreviewBadge(
                        icon = R.drawable.ic_user_small,
                        value = totalUserInvolved,
                    )
                    DiscussionPreviewBadge(
                        icon = R.drawable.ic_chat_bubble_small,
                        value = totalDiscussionBubble,
                    )
                }
            }
        }
    }
}

@Composable
fun DiscussionPreviewBadge(
    @DrawableRes icon: Int,
    value: Int,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Neutral700,
        )
        Text(
            text = value.toString(),
            style = body3Medium,
            color = Neutral700,
        )
    }
}

@Preview
@Composable
fun DiscussionPreviewItemPreview() {
    SiavoUNJTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(16.dp),
        ) {
            DiscussionPreviewItem(
                id = "1",
                title = "Info pencairan dana beasiswa",
                lastDiscussion = "Kapan nih pencarian dana beasiswa kemdikbud? udah hampir 2 tahun",
                latestUpdate = "Hari ini, 14:00 PM",
                totalUserInvolved = 10,
                totalDiscussionBubble = 16,
                onDiscussionClick = {}
            )
        }
    }
}