package dev.diegodc.kalendarz.data.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import dev.diegodc.kalendarz.domain.entities.EventEntity
import java.util.Date

@Entity(
    tableName = "event"
)
data class Event(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val eventDate: Date,
    val customerId: Long
//    //Fields from query
//    @Ignore
//    val name: String = "",
//    @Ignore
//    val email: String = "",
//    @Ignore
//    val phoneNumber: String= "",
//    @Ignore
//    val dob: String = ""
) {
    companion object {
        fun fromEntity(entity: EventEntity): Event {
            return Event(
                id = entity.id,
                title = entity.title,
                eventDate = entity.date,
                customerId = entity.customer.id
            )
        }
    }
}
