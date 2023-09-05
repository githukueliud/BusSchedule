package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(busSchedule: BusSchedule)

    @Update
    suspend fun update(busSchedule: BusSchedule)

    @Delete
    suspend fun delete(busSchedule: BusSchedule)

    @Query("SELECT * FROM BusSchedule WHERE stop_name = :stopName ORDER BY arrival_time ASC")
    fun getBusSchedule(stopName: String): Flow<List<BusSchedule>>

    @Query("SELECT * FROM BusSchedule ORDER BY arrival_time ASC")
    fun getALlBusSchedule(): Flow<List<BusSchedule>>
}