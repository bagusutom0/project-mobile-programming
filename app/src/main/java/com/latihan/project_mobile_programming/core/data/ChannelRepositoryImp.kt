package com.latihan.project_mobile_programming.core.data

import com.latihan.project_mobile_programming.core.data.local.channel.ChannelDao
import com.latihan.project_mobile_programming.core.data.local.channel.toDomain
import com.latihan.project_mobile_programming.core.data.local.channel.toEntity
import com.latihan.project_mobile_programming.core.domain.model.Channel
import com.latihan.project_mobile_programming.core.domain.repository.ChannelRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class ChannelRepositoryImp(private val channelDao: ChannelDao): ChannelRepository {
    override suspend fun insertChannel(channel: Channel) {
        channelDao.insertChannel(channel.toEntity())
    }

    override suspend fun getChannel(): Flow<List<Channel>> {
        return flow {
            emitAll(channelDao.getChannel().map { listChannelEntity -> listChannelEntity.map { it.toDomain() }})
        }
    }

}