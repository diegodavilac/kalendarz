package dev.diegodc.kalendarz.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.diegodc.kalendarz.data.database.dao.CustomerDao
import dev.diegodc.kalendarz.data.database.dao.EventDao
import dev.diegodc.kalendarz.data.repositories.EventRepositoryImpl
import dev.diegodc.kalendarz.domain.repositories.EventRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providesEventRepository(eventDao: EventDao, customerDao: CustomerDao): EventRepository {
        return EventRepositoryImpl(eventDao, customerDao)
    }

}