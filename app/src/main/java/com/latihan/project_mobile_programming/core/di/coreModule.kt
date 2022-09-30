package com.latihan.project_mobile_programming.core.di

import com.latihan.project_mobile_programming.core.data.GrupRepositoryImp
import com.latihan.project_mobile_programming.core.data.UserRepositoryImp
import com.latihan.project_mobile_programming.core.domain.repository.GrupRepository
import com.latihan.project_mobile_programming.core.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<UserRepository> { UserRepositoryImp() }
    single<GrupRepository> { GrupRepositoryImp() }
}