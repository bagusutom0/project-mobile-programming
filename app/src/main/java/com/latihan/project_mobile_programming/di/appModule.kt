package com.latihan.project_mobile_programming.di

import com.latihan.project_mobile_programming.core.domain.usecase.channel.ChannelInteractor
import com.latihan.project_mobile_programming.core.domain.usecase.channel.ChannelUseCase
import com.latihan.project_mobile_programming.core.domain.usecase.todo.TodoInteractor
import com.latihan.project_mobile_programming.core.domain.usecase.todo.TodoUseCase
import com.latihan.project_mobile_programming.core.domain.usecase.user.UserInteractor
import com.latihan.project_mobile_programming.core.domain.usecase.user.UserUseCase
import com.latihan.project_mobile_programming.presentation.viewmodel.ChannelViewModel
import com.latihan.project_mobile_programming.presentation.viewmodel.TodoViewModel
import com.latihan.project_mobile_programming.presentation.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory<UserUseCase> { UserInteractor(get()) }
    factory<ChannelUseCase> { ChannelInteractor(get()) }
    factory<TodoUseCase> { TodoInteractor(get()) }
}

val viewmodelModule = module {
    viewModel { UserViewModel(get()) }
    viewModel { ChannelViewModel(get()) }
    viewModel { TodoViewModel(get()) }
}