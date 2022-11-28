package com.wiryadev.siavounj.data.model

data class Scholarship(
    val id: String,
    val title: String,
    val description: String,
    val deadline: String,
)

val previewScholarship = listOf(
    Scholarship(
        id = "1",
        title = "Beasiswa Unggulan Bank BRI - Batch 4",
        description = "Pembukaan Beasiswa Unggulan dari Bank BRI yang akan dibuka pada 28 Oktober 2022",
        deadline = "12 September 2022"
    ),
    Scholarship(
        id = "2",
        title = "Beasiswa Unggulan Bank BRI - Batch 4",
        description = "Pembukaan Beasiswa Unggulan dari Bank BRI yang akan dibuka pada 28 Oktober 2022",
        deadline = "12 September 2022"
    ),
    Scholarship(
        id = "3",
        title = "Beasiswa Unggulan Bank BRI - Batch 4",
        description = "Pembukaan Beasiswa Unggulan dari Bank BRI yang akan dibuka pada 28 Oktober 2022",
        deadline = "12 September 2022"
    ),
)