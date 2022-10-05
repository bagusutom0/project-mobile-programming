package com.latihan.project_mobile_programming.core.domain.model

data class Todo(
    val todo: String,
    val channel: String,
    val author: String,
    val deadline: String,
    val isChecked: Boolean
)