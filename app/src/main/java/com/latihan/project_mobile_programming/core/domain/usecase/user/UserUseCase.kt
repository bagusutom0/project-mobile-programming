package com.latihan.project_mobile_programming.core.domain.usecase.user

import com.latihan.project_mobile_programming.core.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserUseCase {
    suspend fun insertUser(name: String, email: String, password: String)
    suspend fun getUser(email: String, password: String): Flow<User>
}