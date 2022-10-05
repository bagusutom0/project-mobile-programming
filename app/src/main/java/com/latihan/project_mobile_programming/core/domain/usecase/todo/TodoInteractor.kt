package com.latihan.project_mobile_programming.core.domain.usecase.todo

import com.latihan.project_mobile_programming.core.domain.model.Todo
import com.latihan.project_mobile_programming.core.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class TodoInteractor(private val todoRepository: TodoRepository): TodoUseCase {
    override suspend fun insertTodo(todo: Todo) = todoRepository.insertTodo(todo)
    override suspend fun getTodo(): Flow<List<Todo>> = todoRepository.getTodo()
}