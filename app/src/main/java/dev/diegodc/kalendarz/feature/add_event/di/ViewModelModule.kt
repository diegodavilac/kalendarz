package dev.diegodc.kalendarz.feature.add_event.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dev.diegodc.kalendarz.domain.repositories.EventRepository
import dev.diegodc.kalendarz.domain.usecases.CreateEventUseCase

@InstallIn(ViewModelComponent::class)
@Module
class ViewModelModule {

    @ViewModelScoped
    @Provides
    fun providesCreateEventUseCase(eventRepository: EventRepository) =
        CreateEventUseCase(eventRepository)

}