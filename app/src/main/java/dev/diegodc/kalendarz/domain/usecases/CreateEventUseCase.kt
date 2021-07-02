package dev.diegodc.kalendarz.domain.usecases

import dev.diegodc.kalendarz.domain.repositories.EventRepository
import kotlinx.coroutines.flow.Flow
import java.util.Date
import javax.inject.Inject

class CreateEventUseCase @Inject constructor(
    private val eventRepository: EventRepository
) : UseCase<CreateEventUseCase.CreateEventParams, Long> {

    data class CreateEventParams(
        val type: String,
        val date: Date,
        val phone: String
    )
    override fun call(params: CreateEventParams): Flow<Long> {
        return eventRepository.createEvent(params)
    }
}