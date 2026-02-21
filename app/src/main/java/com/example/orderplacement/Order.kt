package com.example.orderplacement

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "orders")
data class Order(
    @PrimaryKey(autoGenerate = true)
    val orderId: Int = 0,
    val date: String,
    val customerName: String,
    val mobileNumber: String,
    val productDetails: String,
    val quantity: String,
    val address:String
)
