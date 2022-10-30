package com.latihan.project_mobile_programming.core.domain.usecase.channel

import com.latihan.project_mobile_programming.core.domain.model.Channel
import kotlinx.coroutines.flow.Flow

interface ChannelUseCase {
    suspend fun insertChannel(channel: String, author: String)
    suspend fun getChannel(): Flow<List<Channel>>
}