package dev.diegodc.kalendarz.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import dev.diegodc.kalendarz.data.model.Event
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface EventDao {
    @Query("SELECT * FROM event")
    fun getAll(): Flow<List<Event>>

    @Query("SELECT * FROM event WHERE :eventId = id")
    fun getEvent(eventId : Long): Flow<Event>

    @Query("SELECT * FROM event WHERE eventDate BETWEEN :from AND :to")
    fun getEventsFrom(from: Date, to:Date): Flow<List<Event>>

    @Insert
    fun insert(event: Event) : Long

    @Insert
    fun insertAll(vararg events: Event)

    @Delete
    fun delete(event: Event)
}