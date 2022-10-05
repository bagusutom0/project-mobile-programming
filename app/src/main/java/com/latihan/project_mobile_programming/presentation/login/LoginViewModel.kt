package com.latihan.project_mobile_programming.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.latihan.project_mobile_programming.core.domain.model.User
import com.latihan.project_mobile_programming.core.domain.usecase.user.UserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class LoginViewModel(private val userUseCase: UserUseCase): ViewModel() {
    private var user: User? = null

    fun checkUser(email: String, password: String): User? {
        viewModelScope.launch(Dispatchers.IO) {
            userUseCase.getUser(email, password)
                .catch {
                    user = null
                }
                .collect {
                    user = it
                }
        }

        return user
    }
}