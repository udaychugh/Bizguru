package com.udaychugh.mentors

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.razorpay.Checkout
import org.json.JSONObject
import com.razorpay.PaymentResultListener

class sethBuy : AppCompatActivity() {

    lateinit var cancel : Button
    lateinit var buynow : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seth_buy)


        //Checkout.preload(applicationContext)

        cancel=findViewById(R.id.cancel)
        buynow=findViewById(R.id.buynow)

        cancel.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
            finish()
        }

        buynow.setOnClickListener {
            //startPayment()
            Toast.makeText(applicationContext, "Payment Successfull", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, success::class.java)
            startActivity(intent)
            finish()
        }
    }


}