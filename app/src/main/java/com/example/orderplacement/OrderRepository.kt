package com.example.orderplacement

class OrderRepository(private val orderDao: OrderDao) {
    fun getAllOrdersRepo():List<Order> {
        return orderDao.getAllOrders()
    }

    fun insertOrderRepo(order:Order) {
        orderDao.inserOrder(order)
    }

    fun updateOrderRepo(order:Order) {
        orderDao.updateOrder(order)
    }

    fun deleteOrderRepo(order:Order) {
        orderDao.deleteOrder(order)
    }



}