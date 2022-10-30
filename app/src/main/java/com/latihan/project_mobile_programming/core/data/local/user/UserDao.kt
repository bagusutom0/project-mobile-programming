package com.latihan.project_mobile_programming.core.data.local.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM user where email LIKE :email and password LIKE :password")
    suspend fun getUser(email: String, password: String): UserEntity
}