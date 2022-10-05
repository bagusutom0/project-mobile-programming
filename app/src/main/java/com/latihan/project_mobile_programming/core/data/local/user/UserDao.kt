package com.latihan.project_mobile_programming.core.data.local.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM user WHERE email LIKE :email AND password LIKE :password")
    fun getUser(email: String, password: String): Flow<UserEntity>
}