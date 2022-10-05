package com.latihan.project_mobile_programming.core.data.local.todo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.latihan.project_mobile_programming.core.domain.model.Todo

@Entity(tableName = "todo")
data class TodoEntity(
    @PrimaryKey
    val todo: String,
    val channel: String,
    val author: String,
    val deadline: String,
    val isChecked: Boolean
)

fun TodoEntity.toDomain() = Todo(todo, channel, author, deadline, isChecked)
fun Todo.toEntity() = TodoEntity(todo, channel, author, deadline, isChecked)