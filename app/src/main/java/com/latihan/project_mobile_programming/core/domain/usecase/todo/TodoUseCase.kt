package com.latihan.project_mobile_programming.core.domain.usecase.todo

import com.latihan.project_mobile_programming.core.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoUseCase {
    suspend fun insertTodo(todo: Todo)
    suspend fun getTodo(): Flow<List<Todo>>
}