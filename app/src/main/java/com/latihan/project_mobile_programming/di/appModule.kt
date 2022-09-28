package com.latihan.project_mobile_programming.di

import com.latihan.project_mobile_programming.core.domain.usecase.grup.GrupInteractor
import com.latihan.project_mobile_programming.core.domain.usecase.grup.GrupUseCase
import com.latihan.project_mobile_programming.core.domain.usecase.user.UserInteractor
import com.latihan.project_mobile_programming.core.domain.usecase.user.UserUseCase
import org.koin.dsl.module

val appModule = module {
    factory<UserUseCase> { UserInteractor(get()) }
    factory<GrupUseCase> { GrupInteractor(get()) }
}