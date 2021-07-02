package dev.diegodc.kalendarz.feature.home.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dev.diegodc.kalendarz.domain.repositories.EventRepository
import dev.diegodc.kalendarz.domain.usecases.CreateEventUseCase
import dev.diegodc.kalendarz.domain.usecases.GetEventsUseCase

@InstallIn(ViewModelComponent::class)
@Module
class ViewModelModule {

    @Provides
    @ViewModelScoped
    fun providesGetEventsUseCase(eventRepository: EventRepository) =
        GetEventsUseCase(eventRepository)

}