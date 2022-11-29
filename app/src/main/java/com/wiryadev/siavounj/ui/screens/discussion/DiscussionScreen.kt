package com.wiryadev.siavounj.ui.screens.discussion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.wiryadev.siavounj.R
import com.wiryadev.siavounj.data.model.previewDiscussionPreview1
import com.wiryadev.siavounj.data.model.previewDiscussionPreview2
import com.wiryadev.siavounj.ui.components.CommonSectionSlot
import com.wiryadev.siavounj.ui.components.DiscussionPreviewItem
import com.wiryadev.siavounj.ui.components.SearchBar
import com.wiryadev.siavounj.ui.theme.Debutante500
import com.wiryadev.siavounj.ui.theme.body1SemiBold

@Composable
fun DiscussionScreen(
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = remember {
            object : Arrangement.Vertical {
                override fun Density.arrange(
                    totalSize: Int,
                    sizes: IntArray,
                    outPositions: IntArray
                ) {
                    var currentOffset = 0
                    sizes.forEachIndexed { index, size ->
                        if (index == sizes.lastIndex) {
                            outPositions[index] = totalSize - size
                        } else {
                            outPositions[index] = currentOffset
                            currentOffset += size
                        }
                    }
                }
            }
        }
    ) {
        item {
            DiscussionHeader()
            Spacer(modifier = Modifier.height(32.dp))
        }
        item {
            SavedDiscussions()
            Spacer(modifier = Modifier.height(24.dp))
        }
        item {
            AllDiscussion()
            Spacer(modifier = Modifier.height(24.dp))
        }
        item {
            AddDiscussionButton(
                modifier = Modifier.padding(horizontal = 16.dp),
                onAddDiscussionClick = {},
            )
            Spacer(modifier = Modifier.height(32.dp))
        }

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
            text = stringResource(R.string.discussion_forum),
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

@Composable
fun SavedDiscussions(
    modifier: Modifier = Modifier,
) {
    CommonSectionSlot(
        label = stringResource(R.string.saved_discussions),
    ) {
        Column(
            modifier = modifier.padding(horizontal = 16.dp),
        ) {
            previewDiscussionPreview1.forEachIndexed { index, discussion ->
                DiscussionPreviewItem(
                    id = discussion.id,
                    title = discussion.title,
                    lastDiscussion = discussion.lastDiscussion,
                    latestUpdate = discussion.latestUpdate,
                    totalUserInvolved = discussion.totalUserInvolved,
                    totalDiscussionBubble = discussion.totalDiscussionBubble,
                    onDiscussionClick = {},
                    modifier = Modifier.padding(
                        bottom = if (index == previewDiscussionPreview1.size - 1) 0.dp else 12.dp
                    ),
                )
            }
        }
    }
}

@Composable
fun AllDiscussion(
    modifier: Modifier = Modifier,
) {
    CommonSectionSlot(
        label = stringResource(R.string.all_discussions),
    ) {
        Column(
            modifier = modifier.padding(horizontal = 16.dp),
        ) {
            previewDiscussionPreview2.forEach { discussion ->
                DiscussionPreviewItem(
                    id = discussion.id,
                    title = discussion.title,
                    lastDiscussion = discussion.lastDiscussion,
                    latestUpdate = discussion.latestUpdate,
                    totalUserInvolved = discussion.totalUserInvolved,
                    totalDiscussionBubble = discussion.totalDiscussionBubble,
                    onDiscussionClick = {},
                    modifier = Modifier.padding(bottom = 12.dp),
                )
            }
        }
    }
}

@Composable
fun AddDiscussionButton(
    onAddDiscussionClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onAddDiscussionClick,
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 16.dp),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_plus),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = stringResource(R.string.add_topic))
    }
}