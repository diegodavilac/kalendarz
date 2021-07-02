package dev.diegodc.kalendarz.domain.repositories

import dev.diegodc.kalendarz.domain.entities.EventEntity
import dev.diegodc.kalendarz.domain.usecases.CreateEventUseCase
import kotlinx.coroutines.flow.Flow
import java.util.Date


interface EventRepository {
    fun createEvent(param: CreateEventUseCase.CreateEventParams) : Flow<Long>
    fun deleteEvent(param: EventEntity) : Flow<Boolean>
    fun updateEvent(param: EventEntity) : Flow<Boolean>
    fun getEventsFrom(param: Date): Flow<List<EventEntity>>
}