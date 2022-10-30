package com.latihan.project_mobile_programming.core.domain.usecase.todo

import com.latihan.project_mobile_programming.core.domain.model.Todo
import com.latihan.project_mobile_programming.core.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class TodoInteractor(private val todoRepository: TodoRepository): TodoUseCase {
    override suspend fun insertTodo(todo: String, channel: String, author: String, deadline: String, isChecked: Boolean) =
        todoRepository.insertTodo(Todo(todo, channel, author, deadline, isChecked))
    override suspend fun getTodo(): Flow<List<Todo>> = todoRepository.getTodo()
}