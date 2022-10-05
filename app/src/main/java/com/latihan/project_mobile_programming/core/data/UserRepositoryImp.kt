package com.latihan.project_mobile_programming.core.data

import com.latihan.project_mobile_programming.core.data.local.user.UserDao
import com.latihan.project_mobile_programming.core.data.local.user.toDomain
import com.latihan.project_mobile_programming.core.data.local.user.toEntity
import com.latihan.project_mobile_programming.core.domain.model.User
import com.latihan.project_mobile_programming.core.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class UserRepositoryImp(private val userDao: UserDao): UserRepository {
    override suspend fun insetUser(user: User) {
        userDao.insertUser(user.toEntity())
    }

    override suspend fun getUser(email: String, password: String): Flow<User> {
        return flow {
            userDao.getUser(email, password).map { it.toDomain() }
        }
    }
}