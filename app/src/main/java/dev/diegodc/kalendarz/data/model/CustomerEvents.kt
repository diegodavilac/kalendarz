package dev.diegodc.kalendarz.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class CustomerEvents(
    @Embedded val customer: Customer,
    @Relation(
        parentColumn = "id",
        entityColumn = "customerId"
    ) val events: List<Event>
)