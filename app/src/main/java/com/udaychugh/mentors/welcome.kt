package com.udaychugh.mentors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class welcome : AppCompatActivity() {

    lateinit var getStart : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        getStart=findViewById(R.id.started);

        getStart.setOnClickListener {
            val intent = Intent(this, login::class.java);
            startActivity(intent)
        }

    }
}