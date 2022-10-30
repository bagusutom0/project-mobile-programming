package com.latihan.project_mobile_programming.core.data.local.todo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTodo(todo: TodoEntity)

    @Query("SELECT * FROM todo WHERE channel = :channel")
    fun getTodo(channel: String): Flow<List<TodoEntity>>

    @Query("UPDATE todo SET isChecked = :isChecked WHERE todo = :todo")
    fun setCheckedValue(todo: String, isChecked: Boolean)
}