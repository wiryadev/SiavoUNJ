package com.wiryadev.siavounj.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.wiryadev.siavounj.R
import com.wiryadev.siavounj.ui.theme.Neutral700
import com.wiryadev.siavounj.ui.theme.Neutral800
import com.wiryadev.siavounj.ui.theme.Neutral900
import com.wiryadev.siavounj.ui.theme.body2Medium
import com.wiryadev.siavounj.ui.theme.body3
import com.wiryadev.siavounj.ui.theme.body3Medium

@Composable
fun ScholarshipInternItem(
    itemId: String,
    organizerLogo: Any,
    title: String,
    description: String,
    deadline: String,
    modifier: Modifier = Modifier,
    onItemClick: (String) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
            .clickable { onItemClick(itemId) }
            .fillMaxWidth()
            .padding(all = 12.dp),
    ) {
        AsyncImage(
            model = organizerLogo,
            contentDescription = null,
            modifier = Modifier.size(48.dp),
        )
        Column {
            Text(
                text = title,
                maxLines = 1,
                style = body2Medium,
                color = Neutral900,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                maxLines = 2,
                style = body3.copy(
                    fontSize = 11.sp,
                ),
                color = Neutral700,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    text = stringResource(R.string.deadline),
                    style = body3Medium,
                    color = Neutral800,
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = deadline,
                    style = body3,
                    color = Neutral700,
                )
            }
        }
    }
}