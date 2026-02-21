package com.example.orderplacement

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orderplacement.databinding.OrdersListBinding

class OrderAdapter(
    private val list: List<Order>,
    private val onEdit:(Order)-> Unit,
    private val onDelete:(Order)-> Unit,
): RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    inner class OrderViewHolder(val binding: OrdersListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrderViewHolder {
        val binding = OrdersListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: OrderViewHolder,
        position: Int
    ) {
        val order = list[position]

        holder.binding.orderId.text = order.orderId.toString()
        holder.binding.customerName.text = order.customerName.toString()
        holder.binding.orderDate.text = order.date.toString()
        holder.binding.mobileNumber.text = order.mobileNumber.toString()
        holder.binding.productDetails.text = order.productDetails.toString()
        holder.binding.quantity.text = order.quantity.toString()
        holder.binding.address.text = order.address.toString()


        holder.binding.editBTN.setOnClickListener {
            onEdit(order)
        }
        holder.binding.deleteBTN.setOnClickListener {
            onDelete(order)
        }
    }

    override fun getItemCount(): Int = list.size


}