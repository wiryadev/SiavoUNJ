package com.wiryadev.siavounj.data.model

data class Student(
    val id: Int,
    val name: String,
    val totalApply: Int,
    val applyAccepted: Int,
)


val previewStudent = Student(
    id = 1,
    name = "Alvaro Muhammad",
    totalApply = 2,
    applyAccepted = 1,
)