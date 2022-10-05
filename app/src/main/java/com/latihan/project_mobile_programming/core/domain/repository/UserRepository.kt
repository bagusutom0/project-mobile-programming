package com.latihan.project_mobile_programming.core.domain.repository

import com.latihan.project_mobile_programming.core.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun insetUser(user: User)
    suspend fun getUser(email: String, password: String): Flow<User>
}