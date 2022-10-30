package com.latihan.project_mobile_programming.core.data

import com.latihan.project_mobile_programming.core.data.local.todo.TodoDao
import com.latihan.project_mobile_programming.core.data.local.todo.toDomain
import com.latihan.project_mobile_programming.core.data.local.todo.toEntity
import com.latihan.project_mobile_programming.core.domain.model.Todo
import com.latihan.project_mobile_programming.core.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class TodoRepositoryImp(private val todoDao: TodoDao): TodoRepository {
    override suspend fun insertTodo(todo: Todo) {
        todoDao.insertTodo(todo.toEntity())
    }

    override suspend fun getTodo(channel: String): Flow<List<Todo>> {
        return flow {
            emitAll(todoDao.getTodo(channel).map { listTodoEntity -> listTodoEntity.map { it.toDomain()} })
        }
    }

    override suspend fun setCheckedValue(todo: String, isChecked: Boolean) {
        todoDao.setCheckedValue(todo, isChecked)
    }
}