package com.udaychugh.mentors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class home : AppCompatActivity() {

    lateinit var seth : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        seth=findViewById(R.id.mentor1)

        seth.setOnClickListener {
            val intent = Intent(this, sethBuy::class.java)
            startActivity(intent)
        }
    }
}