package com.wiryadev.siavounj.ui.screens.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.wiryadev.siavounj.R
import com.wiryadev.siavounj.data.model.Student
import com.wiryadev.siavounj.data.model.previewStudent
import com.wiryadev.siavounj.ui.theme.JoustBlue600
import com.wiryadev.siavounj.ui.theme.Neutral500
import com.wiryadev.siavounj.ui.theme.Neutral800
import com.wiryadev.siavounj.ui.theme.SiavoUNJTheme
import com.wiryadev.siavounj.ui.theme.body1Bold
import com.wiryadev.siavounj.ui.theme.body2Bold
import com.wiryadev.siavounj.ui.theme.body2Medium
import com.wiryadev.siavounj.ui.theme.body3

@Composable
fun HomeScreen(

) {
    Column {

    }
}

@Composable
fun HomeTopSection(
    student: Student,
    modifier: Modifier = Modifier,
    onViewDetailClick: (Int) -> Unit,
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        val (
            title,
            userCard,
            background,
        ) = createRefs()

        AsyncImage(
            model = R.drawable.bg_top_plain,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .background(Color.Green)
                .constrainAs(background) {
                    top.linkTo(parent.top)
                    bottom.linkTo(userCard.top, margin = (-96).dp)
                    width = Dimension.matchParent
                    height = Dimension.fillToConstraints
                },
        )

        Text(
            text = "SIAVO UNJ",
            style = body1Bold,
            color = Color.White,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top, margin = 40.dp)
                centerHorizontallyTo(parent)
            },
        )

        UserSection(
            student = student,
            onViewDetailClick = onViewDetailClick,
            modifier = Modifier
                .padding(horizontal = 48.dp)
                .constrainAs(userCard) {
                    top.linkTo(title.bottom, margin = 56.dp)
                },
        )
    }
}

@Preview
@Composable
fun HomeTopSectionPreview() {
    SiavoUNJTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            HomeTopSection(
                student = previewStudent,
                onViewDetailClick = {},
            )
        }
    }
}

@Composable
fun UserSection(
    student: Student,
    onViewDetailClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
    ) {
        Column {
            UserSectionTop(name = student.name)
            UserSectionBottom(
                userId = student.id,
                totalApply = student.totalApply,
                applyAccepted = student.applyAccepted,
                onViewDetailClick = onViewDetailClick,
            )
        }
    }
}

@Composable
fun UserSectionTop(
    name: String,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.padding(
                vertical = 24.dp,
                horizontal = UserSectionHorizontalPadding,
            ),
        ) {
            SubcomposeAsyncImage(
                model = R.drawable.fake_profile_pic,
                contentDescription = stringResource(R.string.user_profile_picture),
                loading = { CircularProgressIndicator() },
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(size = 48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.primary)
                    .border(
                        width = 1.dp,
                        color = Neutral500,
                        shape = CircleShape,
                    ),
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = name,
                    style = body2Medium,
                    color = Neutral800,
                )
                Text(
                    text = stringResource(R.string.mahasiswa),
                    style = body3,
                    color = JoustBlue600,
                )
            }
        }
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
        ) {
            drawLine(
                color = Color.Black,
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
            )
        }
    }
}

@Composable
fun UserSectionBottom(
    userId: Int,
    totalApply: Int,
    applyAccepted: Int,
    onViewDetailClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(horizontal = UserSectionHorizontalPadding)
            .padding(top = 16.dp)
            .fillMaxWidth(),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier.fillMaxWidth(),
        ) {
            UserApplicationStatistic(
                label = stringResource(R.string.total_pengajuan),
                value = totalApply,
            )
            UserApplicationStatistic(
                label = stringResource(R.string.status_diterima),
                value = applyAccepted,
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        TextButton(onClick = { onViewDetailClick(userId) }) {
            Text(text = stringResource(R.string.view_detail))
        }
    }
}

@Composable
fun UserApplicationStatistic(
    label: String,
    value: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        Text(
            text = label,
            style = body3,
            color = Neutral800,
        )
        Text(
            text = value.toString(),
            style = body2Bold,
            color = Neutral800,
        )
    }
}

private val UserSectionHorizontalPadding = 24.dp

@Preview
@Composable
fun UserSectionPreview() {
    SiavoUNJTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(16.dp)
        ) {
            UserSection(student = previewStudent, onViewDetailClick = {})
        }
    }
}