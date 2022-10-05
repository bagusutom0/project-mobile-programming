package com.latihan.project_mobile_programming.core.data.local.channel

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ChannelDao {
    @Insert
    suspend fun insertChannel(channel: ChannelEntity)

    @Query("SELECT * FROM channel")
    fun getChannel(): Flow<List<ChannelEntity>>
}