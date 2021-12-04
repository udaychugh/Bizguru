package com.udaychugh.mentors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

class login : AppCompatActivity() {

    lateinit var gotosignup : TextView

    lateinit var lemail : EditText
    lateinit var lpass : EditText
    lateinit var llogin : RelativeLayout

    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        gotosignup=findViewById(R.id.gotosignup)

        lemail=findViewById(R.id.loginmail)
        lpass=findViewById(R.id.loginpassword)
        llogin=findViewById(R.id.login)

        gotosignup.setOnClickListener {
            val intent = Intent(this, signup::class.java)
            startActivity(intent)
        }

        llogin.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                loginuserAccount()
            }
        })


    }

    private fun loginuserAccount() {
        val email : String
        val password : String
        email=lemail.text.toString().trim()
        password=lpass.text.toString().trim()

        if (email.isEmpty() || password.isEmpty())
        {
            Toast.makeText(applicationContext, "Please Enter Email or Password to Signup Account", Toast.LENGTH_SHORT).show()
        }
        else{
            mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){ task ->
                    if(task.isSuccessful){
                        Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, home::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(applicationContext, "Unable to get Account", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}