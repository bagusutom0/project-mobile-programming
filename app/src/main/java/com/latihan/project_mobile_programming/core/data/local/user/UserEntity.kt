package com.latihan.project_mobile_programming.core.data.local.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.latihan.project_mobile_programming.core.domain.model.User

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    val name: String,
    val email: String,
    val password: String
)

fun UserEntity.toDomain() = User(name, email, password)
fun User.toEntity() = UserEntity(name, email, password)