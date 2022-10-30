package com.latihan.project_mobile_programming.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.latihan.project_mobile_programming.core.domain.model.User
import com.latihan.project_mobile_programming.core.domain.usecase.user.UserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class UserViewModel(private val userUseCase: UserUseCase): ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    private val _isUserExist = MutableLiveData<Boolean>()
    val isUserExist: LiveData<Boolean> = _isUserExist

    fun checkUser(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            userUseCase.getUser(email, password)
                .catch {
                    Log.d("LoginViewModel", "checkUser: User not found")
                    _isUserExist.postValue(false)
                }
                .collect {
                    Log.d("LoginViewModel", "checkUser: $it")
                    _isUserExist.postValue(true)
                    _user.postValue(it)
                }
        }
    }

    fun insertNewuser(name: String, email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            userUseCase.insertUser(name, email, password)
        }
    }
}