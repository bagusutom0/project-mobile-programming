package com.latihan.project_mobile_programming.core.domain.usecase.user

import com.latihan.project_mobile_programming.core.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserUseCase {
    suspend fun insetUser(user: User)
    suspend fun getUser(email: String, password: String): Flow<User>
}