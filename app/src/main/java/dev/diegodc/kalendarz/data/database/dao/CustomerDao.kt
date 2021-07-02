package dev.diegodc.kalendarz.data.database.dao

import androidx.room.*
import dev.diegodc.kalendarz.data.model.Customer
import dev.diegodc.kalendarz.data.model.CustomerEvents
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomerDao {
    @Query("SELECT * FROM customer")
    fun getAll(): Flow<List<Customer>>

    @Query("SELECT * FROM customer WHERE :customerId = id")
    fun get(customerId: Long) : Flow<Customer>

    @Insert
    fun insert(customer: Customer): Long

    @Delete
    fun delete(notification: Customer)

    @Transaction
    @Query("SELECT * FROM customer")
    fun getUsersWithEvents(): Flow<List<CustomerEvents>>

    @Transaction
    @Query("SELECT * FROM customer WHERE :customerId = id")
    fun getCustomerWithEvents(customerId: Long): Flow<CustomerEvents>
}