package dev.diegodc.kalendarz.data.repositories

import dev.diegodc.kalendarz.data.database.dao.CustomerDao
import dev.diegodc.kalendarz.data.database.dao.EventDao
import dev.diegodc.kalendarz.data.model.Customer
import dev.diegodc.kalendarz.data.model.Event
import dev.diegodc.kalendarz.domain.entities.CustomerEntity
import dev.diegodc.kalendarz.domain.entities.EventEntity
import dev.diegodc.kalendarz.domain.repositories.EventRepository
import dev.diegodc.kalendarz.domain.usecases.CreateEventUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import java.util.*
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val eventDao: EventDao,
    private val customerDao: CustomerDao
) : EventRepository {

    override fun createEvent(param: CreateEventUseCase.CreateEventParams): Flow<Long> =
        flowOf(
            customerDao
                .insert(Customer(phoneNumber = param.phone))
        ).flowOn(Dispatchers.IO)
            .map { customerId ->
                eventDao.insert(
                    Event(
                        title = param.type,
                        eventDate = param.date,
                        customerId = customerId,
                    )
                )
            }


    override fun deleteEvent(param: EventEntity): Flow<Boolean> {
        TODO("Not yet implemented")
    }

    override fun updateEvent(param: EventEntity): Flow<Boolean> {
        TODO("Not yet implemented")
    }

    override fun getEventsFrom(param: Date): Flow<List<EventEntity>> {

        val calendar = Calendar.getInstance()
        calendar.time = param
        calendar.add(Calendar.DAY_OF_MONTH, 1)

        return eventDao.getEventsFrom(param, calendar.time)
            .flowOn(Dispatchers.IO)
            .map {
                it.map { event ->
                    EventEntity(
                        id = event.id,
                        title = event.title,
                        date = event.eventDate,
                        customer = CustomerEntity(phoneNumber = "")
                    )
                }
            }
    }
}