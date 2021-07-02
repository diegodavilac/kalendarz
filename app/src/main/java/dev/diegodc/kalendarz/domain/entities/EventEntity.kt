package dev.diegodc.kalendarz.domain.entities

import java.util.Date

data class EventEntity(
    val id: Long = 0,
    val title: String,
    val date: Date,
    val customer: CustomerEntity
)
