package com.latihan.project_mobile_programming.core.domain.usecase.channel

import com.latihan.project_mobile_programming.core.domain.model.Channel
import com.latihan.project_mobile_programming.core.domain.repository.ChannelRepository
import kotlinx.coroutines.flow.Flow

class ChannelInteractor(private val channelRepository: ChannelRepository): ChannelUseCase {
    override suspend fun insertChannel(channel: String, author: String) = channelRepository.insertChannel(Channel(channel, author))
    override suspend fun getChannel(): Flow<List<Channel>>  =channelRepository.getChannel()
}