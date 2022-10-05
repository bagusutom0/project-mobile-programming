package com.latihan.project_mobile_programming.core.domain.repository

import com.latihan.project_mobile_programming.core.domain.model.Channel
import kotlinx.coroutines.flow.Flow

interface ChannelRepository {
    suspend fun insertChannel(channel: Channel)
    suspend fun getChannel(): Flow<List<Channel>>
}