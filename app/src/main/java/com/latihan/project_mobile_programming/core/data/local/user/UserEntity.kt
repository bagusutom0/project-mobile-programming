package com.latihan.project_mobile_programming.core.data.local.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.latihan.project_mobile_programming.core.domain.model.User

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "password")
    val password: String
)

fun UserEntity.toDomain() = User(name, email, password)
fun User.toEntity() = UserEntity(name, email, password)