package com.wiryadev.siavounj.data.model

data class NotificationPreview(
    val title: String,
    val dateTime: String,
    val isRead: Boolean,
)

val previewNotificationPreview = listOf(
    NotificationPreview(
        title = "Pengingat: Beasiswa Unggulan dari BRI telah dibuka. Yuk daftar sekarang!",
        dateTime = "13 Aug 2022, 20:00 PM",
        isRead = true,
    ),
    NotificationPreview(
        title = "Pengingat: Magang Kampus Merdeka Batch 3 telah dibuka. Yuk daftar sekarang!!!",
        dateTime = "13 Aug 2022, 20:00 PM",
        isRead = true,
    ),
    NotificationPreview(
        title = "Pengajuan berkas Pengurangan UKT berhasil",
        dateTime = "13 Aug 2022, 20:00 PM",
        isRead = false,
    ),
    NotificationPreview(
        title = "Pengumuman beasiswa Unggulan BRI. Cek status beasiswamu sekarang!!",
        dateTime = "13 Aug 2022, 20:00 PM",
        isRead = false,
    ),
)
