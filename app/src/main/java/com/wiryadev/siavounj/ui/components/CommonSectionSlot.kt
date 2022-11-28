package com.wiryadev.siavounj.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wiryadev.siavounj.ui.theme.Neutral900
import com.wiryadev.siavounj.ui.theme.body1SemiBold

@Composable
fun CommonSectionSlot(
    label: String,
    modifier: Modifier = Modifier,
    viewAll: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {
            Text(
                text = label,
                style = body1SemiBold,
                color = Neutral900,
            )
            viewAll?.invoke()
        }
        content()
    }
}