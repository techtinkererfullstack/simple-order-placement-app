package com.example.orderplacement

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class OrderViewModel(application: Application): AndroidViewModel(application)  {
    private val repository: OrderRepository
    val orderLiveData = MutableLiveData<List<Order>>()

    init {
        val dao = AppDatabase.getDatabase(application).orderDao()
        repository = OrderRepository(dao)
        getAllOrderFromViewModel()
    }

    fun getAllOrderFromViewModel(){
       orderLiveData.value = repository.getAllOrdersRepo()
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