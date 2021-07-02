package dev.diegodc.kalendarz.domain.usecases

import dev.diegodc.kalendarz.domain.entities.EventEntity
import dev.diegodc.kalendarz.domain.repositories.EventRepository
import kotlinx.coroutines.flow.Flow
import java.util.Date
import javax.inject.Inject

class GetEventsUseCase @Inject constructor(
    private val eventsRepository: EventRepository
) : UseCase<Date, List<EventEntity>> {
    override fun call(params: Date): Flow<List<EventEntity>> {
        return eventsRepository.getEventsFrom(params)
    }
}