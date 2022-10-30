package com.latihan.project_mobile_programming.core.domain.usecase.todo

import com.latihan.project_mobile_programming.core.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoUseCase {
    suspend fun insertTodo(todo: String, channel: String, author: String, deadline: String, isChecked: Boolean)
    suspend fun getTodo(): Flow<List<Todo>>
}