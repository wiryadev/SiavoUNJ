package com.wiryadev.siavounj.ui.screens.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.wiryadev.siavounj.R
import com.wiryadev.siavounj.data.model.Student
import com.wiryadev.siavounj.data.model.previewInternship
import com.wiryadev.siavounj.data.model.previewLatestInfo
import com.wiryadev.siavounj.data.model.previewScholarship
import com.wiryadev.siavounj.data.model.previewStudent
import com.wiryadev.siavounj.ui.components.CommonSectionSlot
import com.wiryadev.siavounj.ui.components.LatestInfoItem
import com.wiryadev.siavounj.ui.components.ScholarshipInternItem
import com.wiryadev.siavounj.ui.components.UserProfilePicture
import com.wiryadev.siavounj.ui.theme.Debutante300
import com.wiryadev.siavounj.ui.theme.Debutante600
import com.wiryadev.siavounj.ui.theme.Drunken500
import com.wiryadev.siavounj.ui.theme.JoustBlue600
import com.wiryadev.siavounj.ui.theme.Neutral800
import com.wiryadev.siavounj.ui.theme.SiavoUNJTheme
import com.wiryadev.siavounj.ui.theme.body1SemiBold
import com.wiryadev.siavounj.ui.theme.body2
import com.wiryadev.siavounj.ui.theme.body2Medium
import com.wiryadev.siavounj.ui.theme.body3
import com.wiryadev.siavounj.ui.theme.body3Medium

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        modifier = modifier.fillMaxSize(),
    ) {
        item {
            HomeTopSection(
                student = previewStudent,
                onViewDetailClick = {},
            )
        }
        item { GuideSection() }
        item { LatestInfoSection() }
        item { ScholarshipSection() }
        item { InternshipSection() }
        item { Spacer(modifier = Modifier.height(16.dp)) }
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
            model = R.drawable.bg_home_top,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.constrainAs(background) {
                top.linkTo(parent.top)
                bottom.linkTo(userCard.top, margin = (-96).dp)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            },
        )

        Text(
            text = "SIAVO UNJ",
            style = body1SemiBold,
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
fun GuideSection(
    modifier: Modifier = Modifier,
) {
    CommonSectionSlot(
        label = stringResource(R.string.panduan)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier.padding(horizontal = 16.dp),
        ) {
            GuideItem(
                title = stringResource(R.string.pengumpulan_berkas),
                illustration = R.drawable.illustration_submit_files,
                backgroundColor = Debutante300,
                modifier = Modifier.weight(1f),
                onGuideClick = {},
            )
            GuideItem(
                title = stringResource(R.string.penggunaan_aplikasi),
                illustration = R.drawable.illustration_using_app,
                backgroundColor = Drunken500,
                modifier = Modifier.weight(1f),
                onGuideClick = {},
            )
        }
    }
}

@Preview
@Composable
fun GuideSectionPreview() {
    SiavoUNJTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(16.dp),
        ) {
            GuideSection()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GuideItem(
    title: String,
    @DrawableRes illustration: Int,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    onGuideClick: () -> Unit,
) {
    Card(
        elevation = 4.dp,
        onClick = onGuideClick,
        modifier = modifier,
    ) {
        Box {
            AsyncImage(
                model = illustration,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(backgroundColor),
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(vertical = 12.dp),
            ) {
                Text(
                    text = title,
                    style = body3Medium,
                    color = Neutral800,
                )
            }
        }
    }
}

@Composable
fun LatestInfoSection(
    modifier: Modifier = Modifier,
) {
    CommonSectionSlot(
        label = stringResource(R.string.latest_info)
    ) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier,
        ) {
            items(
                items = previewLatestInfo,
                key = { it.id }
            ) { info ->
                LatestInfoItem(
                    title = info.title,
                    subtitle = info.subtitle,
                ) {

                }
            }
        }
    }
}

@Composable
fun ScholarshipSection(
    modifier: Modifier = Modifier,
) {
    CommonSectionSlot(
        label = stringResource(R.string.scholarship),
        viewAll = {
            Text(
                text = stringResource(R.string.view_all),
                style = body2,
                color = Debutante600,
                modifier = Modifier.clickable { }
            )
        }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = modifier.padding(horizontal = 16.dp),
        ) {
            previewScholarship.forEach { scholarship ->
                ScholarshipInternItem(
                    itemId = scholarship.id,
                    organizerLogo = R.drawable.tut_wuri_handayani,
                    title = scholarship.title,
                    description = scholarship.description,
                    deadline = scholarship.deadline,
                    onItemClick = {},
                )
                Divider()
            }
        }
    }
}

@Composable
fun InternshipSection(
    modifier: Modifier = Modifier,
) {
    CommonSectionSlot(
        label = stringResource(R.string.intern_opportunity),
        viewAll = {
            Text(
                text = stringResource(R.string.view_all),
                style = body2,
                color = Debutante600,
                modifier = Modifier.clickable { }
            )
        }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = modifier.padding(horizontal = 16.dp),
        ) {
            previewInternship.forEach { internship ->
                ScholarshipInternItem(
                    itemId = internship.id,
                    organizerLogo = R.drawable.kampus_merdeka,
                    title = internship.title,
                    description = internship.description,
                    deadline = internship.deadline,
                    onItemClick = {},
                )
                Divider()
            }
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
        elevation = 4.dp,
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
            UserProfilePicture(size = 48.dp)
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
                valueTextColor = Debutante600,
            )
            UserApplicationStatistic(
                label = stringResource(R.string.status_diterima),
                value = applyAccepted,
                valueTextColor = JoustBlue600,
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
    valueTextColor: Color,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
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
            style = body1SemiBold,
            color = valueTextColor,
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