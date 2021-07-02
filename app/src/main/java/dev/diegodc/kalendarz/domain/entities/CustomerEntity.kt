package dev.diegodc.kalendarz.domain.entities

data class CustomerEntity(
    val id: Long = 0,
    val name: String = "",
    val email:String = "",
    val phoneNumber: String ,
    val dob: String = ""
)
