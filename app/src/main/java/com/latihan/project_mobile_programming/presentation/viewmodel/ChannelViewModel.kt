package com.latihan.project_mobile_programming.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.latihan.project_mobile_programming.core.domain.model.Channel
import com.latihan.project_mobile_programming.core.domain.usecase.channel.ChannelUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChannelViewModel(private val channelUseCase: ChannelUseCase): ViewModel() {
    private val _listChannel = MutableLiveData<List<Channel>> ()
    val listChannel: LiveData<List<Channel>> = _listChannel

    init {
        getChannel()
    }

    fun insertChannel(name: String, author: String) {
        viewModelScope.launch(Dispatchers.IO) {
            channelUseCase.insertChannel(name, author)
        }
    }

    private fun getChannel() {
        viewModelScope.launch(Dispatchers.IO) {
            channelUseCase.getChannel()
                .collect {
                    _listChannel.postValue(it)
                }
        }
    }
}