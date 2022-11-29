package com.wiryadev.siavounj.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wiryadev.siavounj.R
import com.wiryadev.siavounj.ui.theme.SiavoUNJTheme

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        placeholder = {
            Text(
                text = placeholder,
                style = MaterialTheme.typography.body2,
            )
        },
        modifier = modifier.fillMaxWidth(),
        textStyle = MaterialTheme.typography.body2,
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = null,
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = MaterialTheme.colors.background,
        )
    )
}

@Preview
@Composable
fun SearchBarPreview() {
    SiavoUNJTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(16.dp),
        ) {
            SearchBar(
                query = "",
                onQueryChange = {},
                placeholder = stringResource(R.string.find_discussion_topic),
            )
        }
    }
}