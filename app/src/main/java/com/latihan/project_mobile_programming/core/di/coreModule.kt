package com.latihan.project_mobile_programming.core.di

import androidx.room.Room
import com.latihan.project_mobile_programming.core.data.ChannelRepositoryImp
import com.latihan.project_mobile_programming.core.data.TodoRepositoryImp
import com.latihan.project_mobile_programming.core.data.UserRepositoryImp
import com.latihan.project_mobile_programming.core.data.local.TodoDatabase
import com.latihan.project_mobile_programming.core.domain.repository.ChannelRepository
import com.latihan.project_mobile_programming.core.domain.repository.TodoRepository
import com.latihan.project_mobile_programming.core.domain.repository.UserRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val repositoryModule = module {
    single<UserRepository> { UserRepositoryImp(get()) }
    single<ChannelRepository> { ChannelRepositoryImp(get()) }
    single<TodoRepository> { TodoRepositoryImp(get()) }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            TodoDatabase::class.java,
            "todo.db"
        ).fallbackToDestructiveMigration().build()
    }

    single {get<TodoDatabase>().channelDao()}
    single {get<TodoDatabase>().todoDao()}
    single {get<TodoDatabase>().userDao()}
}
