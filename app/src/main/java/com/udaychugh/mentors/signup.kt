package com.udaychugh.mentors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

class signup : AppCompatActivity() {

    lateinit var gotologin : TextView

    lateinit var semail : EditText
    lateinit var spass: EditText
    lateinit var ssignup : RelativeLayout

    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        mAuth = FirebaseAuth.getInstance()

        gotologin=findViewById(R.id.gotologin)

        semail=findViewById(R.id.signupmail)
        spass=findViewById(R.id.signuppassword)
        ssignup=findViewById(R.id.signup)

        ssignup.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                registerNewUser()
            }
        })





        gotologin.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }

        val categ = resources.getStringArray(R.array.fresherMentor)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_list, categ)
        val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.whoareyou)
        autocompleteTV.setAdapter(arrayAdapter)
    }

    private fun registerNewUser() {
        val email : String
        val password : String
        email=semail.text.toString().trim()
        password=spass.text.toString().trim()

        if (email.isEmpty() || password.isEmpty())
        {
            Toast.makeText(applicationContext, "Please Enter Email or Password to Signup Account", Toast.LENGTH_SHORT).show()
        }
        else{
            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){ task ->
                    if (task.isSuccessful){
                        Toast.makeText(applicationContext, "Registration Successfull", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, introduce::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(applicationContext, "Registration Unsuccessfull", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}