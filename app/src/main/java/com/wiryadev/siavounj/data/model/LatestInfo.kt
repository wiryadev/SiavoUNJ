package com.wiryadev.siavounj.data.model

data class LatestInfo(
    val id: String,
    val title: String,
    val subtitle: String,
)

val previewLatestInfo = listOf(
    LatestInfo(
        id = "1",
        title = "Pengajuan Pengurangan UKT",
        subtitle = "Pengajuan beasiswa UKT Semester 117"
    ),
    LatestInfo(
        id = "2",
        title = "Pengumuman Beasiswa Kemendikbud",
        subtitle = "Pengajuan beasiswa UKT Semester 117"
    )
)
