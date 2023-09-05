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

    @Query("SELECT * FROM BusSchedule WHERE id = :id ")
    fun getBusSchedule(id: Int): Flow<BusSchedule>

    @Query("SELECT * FROM BusSchedule ORDER BY arrivalTimeInMillis DESC LIMIT 1")
    fun getALlBusSchedule(): Flow<List<BusSchedule>>
}