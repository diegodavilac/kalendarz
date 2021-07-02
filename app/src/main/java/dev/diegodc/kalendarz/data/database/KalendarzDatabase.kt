package dev.diegodc.kalendarz.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.diegodc.kalendarz.data.database.dao.CustomerDao
import dev.diegodc.kalendarz.data.database.dao.EventDao
import dev.diegodc.kalendarz.data.model.Customer
import dev.diegodc.kalendarz.data.model.Event

@Database(
    entities = [Customer::class, Event::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class KalendarzDatabase : RoomDatabase() {
    abstract fun customerDao(): CustomerDao
    abstract fun eventsDao(): EventDao
}