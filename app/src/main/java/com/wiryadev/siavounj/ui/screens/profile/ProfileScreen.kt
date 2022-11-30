package com.wiryadev.siavounj.ui.screens.profile

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wiryadev.siavounj.R
import com.wiryadev.siavounj.ui.components.UserProfilePicture
import com.wiryadev.siavounj.ui.theme.Debutante600
import com.wiryadev.siavounj.ui.theme.Neutral1000
import com.wiryadev.siavounj.ui.theme.SiavoUNJTheme
import com.wiryadev.siavounj.ui.theme.body1
import com.wiryadev.siavounj.ui.theme.body1SemiBold
import com.wiryadev.siavounj.ui.theme.body2

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        ProfileAppBar()
        LazyColumn(
            contentPadding = PaddingValues(all = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            item {
                ProfileCard(
                    name = "Alvaro Muhammad",
                    faculty = "F. Teknik 2019",
                )
            }
            item {
                ContactSection()
            }
            item {
                SettingSection()
            }
        }
    }
}

@Composable
fun ProfileAppBar(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 24.dp),
    ) {
        Text(
            text = stringResource(id = R.string.profile),
            style = body1SemiBold,
            color = Debutante600,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(),
        )

    }
}

@Composable
fun ProfileCard(
    name: String,
    faculty: String,
    modifier: Modifier = Modifier,
) {
    Card(
        elevation = 4.dp,
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.padding(all = 16.dp),
        ) {
            UserProfilePicture(size = 92.dp)
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = name,
                    style = body1SemiBold,
                    color = Neutral1000,
                )
                Column {
                    Text(
                        text = stringResource(R.string.mahasiswa),
                        style = body2,
                        color = Neutral1000,
                    )
                    Text(
                        text = faculty,
                        style = body2,
                        color = Neutral1000,
                    )
                }
            }
        }
    }
}

@Composable
fun ContactSection(
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
    ) {
        ContactItem(
            icon = R.drawable.ic_phone,
            value = "+6285254241234",
        )
        ContactItem(
            icon = R.drawable.ic_envelope_open,
            value = "alvarom_1512619111@mhs.unj.ac.id",
        )
    }
}

@Composable
fun ContactItem(
    @DrawableRes icon: Int,
    value: String,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxWidth(),
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Neutral1000,
        )
        Text(
            text = value,
            style = body1,
            color = Neutral1000,
        )
    }
}

@Composable
fun SettingSection(
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxWidth(),
    ) {
        SettingItem(
            icon = R.drawable.ic_key,
            value = stringResource(R.string.change_password),
        )
        SettingItem(
            icon = R.drawable.ic_file_history,
            value = stringResource(R.string.apply_history),
        )
    }
}

@Composable
fun SettingItem(
    @DrawableRes icon: Int,
    value: String,
    modifier: Modifier = Modifier,
) {
    Card(
        elevation = 4.dp,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(all = 16.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = Neutral1000,
                )
                Text(
                    text = value,
                    style = body1,
                    color = Neutral1000,
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
fun ProfileCardPreview() {
    SiavoUNJTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(16.dp)
        ) {
            ProfileCard(name = "Alvaro Muhammad", faculty = "F. Teknik 2019")
        }
    }
}