package com.latihan.project_mobile_programming.core.data.local.todo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Insert
    suspend fun insertTodo(todo: TodoEntity)

    @Query("SELECT * FROM todo")
    fun getTodo(): Flow<List<TodoEntity>>
}