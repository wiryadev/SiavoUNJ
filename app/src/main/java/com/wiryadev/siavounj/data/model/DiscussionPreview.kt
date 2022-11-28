package com.wiryadev.siavounj.data.model

data class DiscussionPreview(
    val id: String,
    val title: String,
    val lastDiscussion: String,
    val latestUpdate: String,
    val totalUserInvolved: Int,
    val totalDiscussionBubble: Int,
)

val previewDiscussionPreview1 = listOf(
    DiscussionPreview(
        id = "1",
        title = "Info pencairan dana beasiswa",
        lastDiscussion = "Kapan nih pencarian dana beasiswa kemdikbud? udah hampir 2 tahun",
        latestUpdate = "Hari ini, 14:00 PM",
        totalUserInvolved = 10,
        totalDiscussionBubble = 16,
    )
)

val previewDiscussionPreview2 = listOf(
    DiscussionPreview(
        id = "2",
        title = "Pengajuan UKT",
        lastDiscussion = "Minimal semester berapa buat ngajuin pengurangan UKT min??",
        latestUpdate = "14 Oktober 2022",
        totalUserInvolved = 4,
        totalDiscussionBubble = 12,
    ),
    DiscussionPreview(
        id = "3",
        title = "Info Studi Independen Kampus Merdeka",
        lastDiscussion = "Kok saya ngga bisa upload SPTJM ya?",
        latestUpdate = "Hari ini, 08:00 AM",
        totalUserInvolved = 40,
        totalDiscussionBubble = 100,
    ),
)