package com.latihan.project_mobile_programming.core.data.local.channel

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.latihan.project_mobile_programming.core.domain.model.Channel

@Entity(tableName = "channel")
data class ChannelEntity(
    @PrimaryKey
    val channel: String,
    val author: String
)

fun ChannelEntity.toDomain() = Channel(channel, author)
fun Channel.toEntity() = ChannelEntity(channel, author)