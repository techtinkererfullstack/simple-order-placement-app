package com.example.orderplacement

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orderplacement.databinding.ActivityAllOrdersScreenBinding

class AllOrdersScreen : AppCompatActivity() {
    private lateinit var binding: ActivityAllOrdersScreenBinding
    private lateinit var viewModel: OrderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAllOrdersScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel = ViewModelProvider(this)[OrderViewModel::class.java]

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, AddOrderScreen::class.java))
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.orderLiveData.observe(this) { list ->
        binding.counter.text = list.size.toString()
            val adapter = OrderAdapter(
                list,

                onEdit = { order->
                    val intent = Intent(this@AllOrdersScreen, AddOrderScreen::class.java)

                    intent.putExtra("id",order.orderId)
                    intent.putExtra("customerName",order.customerName)
                    intent.putExtra("mobileNumber",order.mobileNumber)
                    intent.putExtra("date",order.date)
                    intent.putExtra("productDetails",order.productDetails)
                    intent.putExtra("quantity",order.quantity)
                    intent.putExtra("address",order.address)
                    startActivity(intent)

                },
                onDelete = {order ->
                   viewModel.deleteOrderFromViewModel(order)
                    viewModel.getAllOrderFromViewModel()

                }
            )

            binding.recyclerView.adapter = adapter

        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllOrderFromViewModel()
    }



}