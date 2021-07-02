package dev.diegodc.kalendarz.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.diegodc.kalendarz.domain.entities.CustomerEntity

@Entity(
    tableName = "customer"
)
data class Customer(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String = "",
    val email: String = "",
    val phoneNumber: String,
    val dob: String = ""
){
    companion object{
        fun fromEntity(entity: CustomerEntity): Customer{
            return Customer(
                id = entity.id,
                name = entity.name,
                email = entity.email,
                phoneNumber = entity.phoneNumber,
                dob = entity.dob
            )
        }
    }
}
