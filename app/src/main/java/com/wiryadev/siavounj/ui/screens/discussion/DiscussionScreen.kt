package com.wiryadev.siavounj.ui.screens.discussion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.wiryadev.siavounj.R
import com.wiryadev.siavounj.ui.components.SearchBar
import com.wiryadev.siavounj.ui.theme.Debutante500
import com.wiryadev.siavounj.ui.theme.body1SemiBold

@Composable
fun DiscussionScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        DiscussionHeader()
    }
}

@Composable
fun DiscussionHeader(
    modifier: Modifier = Modifier,
) {
    ConstraintLayout(
        modifier = modifier.fillMaxWidth()
    ) {
        val (
            background,
            title,
            searchbar,
        ) = createRefs()

        Box(
            modifier = Modifier
                .background(color = Debutante500)
                .height(124.dp)
                .constrainAs(background) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.matchParent
                },
        )

        Text(
            text = "Forum Diskusi",
            style = body1SemiBold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top, margin = 40.dp)
                centerHorizontallyTo(parent)
            }
        )

        SearchBar(
            query = "",
            onQueryChange = {},
            placeholder = stringResource(id = R.string.find_discussion_topic),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .constrainAs(searchbar) {
                    top.linkTo(background.bottom)
                    bottom.linkTo(background.bottom)
                    centerHorizontallyTo(parent)
                }
        )
    }
}