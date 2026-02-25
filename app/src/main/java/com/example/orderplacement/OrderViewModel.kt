package com.example.orderplacement

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class OrderViewModel(application: Application): AndroidViewModel(application)  {
    private val repository: OrderRepository

    init {
        val dao = AppDatabase.getDatabase(application).orderDao()
        repository = OrderRepository(dao)
        getAllOrderFromViewModel()
    }

    fun getAllOrderFromViewModel():List<Order> {
        return repository.getAllOrdersRepo()
    }

    fun insertOrderFromViewModel(order:Order) {
        repository.insertOrderRepo(order)
    }

    fun updateOrderFromViewModel(order:Order) {
        repository.updateOrderRepo(order)
    }

    fun deleteOrderFromViewModel(order:Order) {
        repository.deleteOrderRepo(order)
    }



}