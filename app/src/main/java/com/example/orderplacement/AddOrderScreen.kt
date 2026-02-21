package com.example.orderplacement

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.orderplacement.databinding.ActivityAddOrderScreenBinding

class AddOrderScreen : AppCompatActivity() {
    private lateinit var binding: ActivityAddOrderScreenBinding

    private lateinit var db: AppDatabase

    private var orderid = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddOrderScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //getDatabase function called
        db = AppDatabase.getDatabase(this)

        orderid =intent.getIntExtra("id",-1)

        if (orderid!=-1){

            binding.dateET.setText(intent.getStringExtra("date"))
            binding.customerNameET.setText(intent.getStringExtra("customerName"))
            binding.mobileNumberET.setText(intent.getStringExtra("mobileNumber"))
            binding.productDetailsET.setText(intent.getStringExtra("productDetails"))
            binding.quantityET.setText(intent.getStringExtra("quantity"))
            binding.addressET.setText(intent.getStringExtra("address"))

        }

        binding.orderButton.setOnClickListener {
            val date = binding.dateET.text.toString()
            val customerName = binding.customerNameET.text.toString()
            val mobileNumber = binding.mobileNumberET.text.toString()
            val productDetails = binding.productDetailsET.text.toString()
            val quantity = binding.quantityET.text.toString()
            val address = binding.addressET.text.toString()

            if (orderid== -1){
                //insert
                val order = Order(address = address,date = date, customerName = customerName, mobileNumber = mobileNumber, productDetails = productDetails, quantity = quantity)
                db.orderDao().inserOrder(order)

            }else{
                //Update
                val order =Order(address = address,orderId = orderid, date = date, customerName = customerName, mobileNumber = mobileNumber, productDetails = productDetails, quantity = quantity)
                db.orderDao().updateOrder(order)
            }
            Toast.makeText(this@AddOrderScreen, "Order saved successfully", Toast.LENGTH_SHORT).show()
            finish()


        }


    }
}