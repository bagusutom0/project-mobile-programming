package com.latihan.project_mobile_programming.core.domain.usecase.user

import com.latihan.project_mobile_programming.core.domain.repository.UserRepository

class UserInteractor(private val userRepository: UserRepository): UserUseCase {
}