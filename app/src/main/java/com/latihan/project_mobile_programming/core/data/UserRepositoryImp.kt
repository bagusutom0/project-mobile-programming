package com.latihan.project_mobile_programming.core.data

import com.latihan.project_mobile_programming.core.data.local.user.UserDao
import com.latihan.project_mobile_programming.core.data.local.user.toDomain
import com.latihan.project_mobile_programming.core.data.local.user.toEntity
import com.latihan.project_mobile_programming.core.domain.model.User
import com.latihan.project_mobile_programming.core.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepositoryImp(private val userDao: UserDao): UserRepository {
    override suspend fun insertUser(name: String, email: String, password: String) {
        userDao.insertUser(User(name, email, password).toEntity())
    }

    override suspend fun getUser(email: String, password: String): Flow<User> {
        return flow {
            emit(userDao.getUser(email, password).toDomain())
        }
    }
}