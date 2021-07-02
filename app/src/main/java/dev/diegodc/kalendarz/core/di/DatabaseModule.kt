package dev.diegodc.kalendarz.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.diegodc.kalendarz.data.database.KalendarzDatabase
import dev.diegodc.kalendarz.data.database.dao.CustomerDao
import dev.diegodc.kalendarz.data.database.dao.EventDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun providesEventsDao(database: KalendarzDatabase) : EventDao{
        return database.eventsDao()
    }

    @Provides
    fun providesCustomerDao(database: KalendarzDatabase) : CustomerDao{
        return database.customerDao()
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext applicationContext: Context): KalendarzDatabase {
        return Room.databaseBuilder(
            applicationContext, KalendarzDatabase::class.java, "kalendarz-database"
        ).build()
    }

}