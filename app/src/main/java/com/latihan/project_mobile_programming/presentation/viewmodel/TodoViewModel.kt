package com.latihan.project_mobile_programming.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.latihan.project_mobile_programming.core.domain.model.Todo
import com.latihan.project_mobile_programming.core.domain.usecase.todo.TodoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(private val todoUseCase: TodoUseCase): ViewModel() {
    private val _listTodo = MutableLiveData<List<Todo>> ()
    val listTodo: LiveData<List<Todo>> = _listTodo

    init {
        getTodo()
    }

    fun insertTodo(todo: String, channel: String, author: String, deadline: String, isChecked: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            todoUseCase.insertTodo(todo, channel, author, deadline, isChecked)
        }
    }

    private fun getTodo() {
        viewModelScope.launch(Dispatchers.IO) {
            todoUseCase.getTodo()
                .collect {
                    _listTodo.postValue(it)
                }
        }
    }
}