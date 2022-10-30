package com.latihan.project_mobile_programming.core.domain.usecase.user

import com.latihan.project_mobile_programming.core.domain.model.User
import com.latihan.project_mobile_programming.core.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserInteractor(private val userRepository: UserRepository): UserUseCase {
    override suspend fun insertUser(name: String, email: String, password: String) =
        userRepository.insertUser(name, email, password)

    override suspend fun getUser(email: String, password: String): Flow<User> =
        userRepository.getUser(email, password)
}