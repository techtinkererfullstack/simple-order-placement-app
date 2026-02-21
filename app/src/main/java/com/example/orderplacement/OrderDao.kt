package com.example.orderplacement

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface OrderDao {

    @Insert
    fun inserOrder(order: Order)

    @Update
    fun updateOrder(order: Order)

    @Delete
    fun deleteOrder(order: Order)

    @Query("SELECT * FROM orders")
    fun getAllOrders(): List<Order>

}