package com.wiryadev.siavounj.data.model

data class Internship(
    val id: String,
    val title: String,
    val description: String,
    val deadline: String,
)

val previewInternship = listOf(
    Internship(
        id = "1",
        title = "Magang Kampus Merdeka - Batch 5",
        description = "Kegiatan magang yang dikelola oleh pemerintah untuk mahasiswa untuk menambah pengalaman bekerja",
        deadline = "12 September 2022"
    ),
    Internship(
        id = "2",
        title = "Magang Kampus Merdeka - Batch 5",
        description = "Kegiatan magang yang dikelola oleh pemerintah untuk mahasiswa untuk menambah pengalaman bekerja",
        deadline = "12 September 2022"
    ),
    Internship(
        id = "3",
        title = "Magang Kampus Merdeka - Batch 5",
        description = "Kegiatan magang yang dikelola oleh pemerintah untuk mahasiswa untuk menambah pengalaman bekerja",
        deadline = "12 September 2022"
    ),
)
