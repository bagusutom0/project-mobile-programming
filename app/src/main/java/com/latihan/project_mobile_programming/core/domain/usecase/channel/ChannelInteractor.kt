package com.latihan.project_mobile_programming.core.domain.usecase.channel

import com.latihan.project_mobile_programming.core.domain.model.Channel
import com.latihan.project_mobile_programming.core.domain.repository.ChannelRepository
import kotlinx.coroutines.flow.Flow

class ChannelInteractor(private val channelRepository: ChannelRepository): ChannelUseCase {
    override suspend fun insertChannel(channel: Channel) = channelRepository.insertChannel(channel)
    override suspend fun getChannel(): Flow<List<Channel>>  =channelRepository.getChannel()
}