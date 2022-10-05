package com.latihan.project_mobile_programming.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.latihan.project_mobile_programming.core.data.local.channel.ChannelDao
import com.latihan.project_mobile_programming.core.data.local.channel.ChannelEntity
import com.latihan.project_mobile_programming.core.data.local.todo.TodoDao
import com.latihan.project_mobile_programming.core.data.local.todo.TodoEntity
import com.latihan.project_mobile_programming.core.data.local.user.UserDao
import com.latihan.project_mobile_programming.core.data.local.user.UserEntity

@Database(entities = [ChannelEntity::class, TodoEntity::class, UserEntity::class], version = 1)
abstract class TodoDatabase: RoomDatabase() {
    abstract fun channelDao(): ChannelDao
    abstract fun todoDao(): TodoDao
    abstract fun userDao(): UserDao
}