package com.udaychugh.mentors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.FirebaseDatabase

class introduce : AppCompatActivity() {

    lateinit var nextbtn: Button

    lateinit var onlinecard: CardView
    lateinit var offlinecard: CardView

    lateinit var businessCateg : EditText
    lateinit var market : EditText

    lateinit var beginner: RelativeLayout
    lateinit var medium: RelativeLayout
    lateinit var expert: RelativeLayout

    private lateinit var database : DatabaseReference
    private lateinit var firebaseDatabase: FirebaseDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduce)

        database = Firebase.database.reference
        firebaseDatabase = FirebaseDatabase.getInstance()

        nextbtn=findViewById(R.id.next)

        onlinecard=findViewById(R.id.onlinecard)
        offlinecard=findViewById(R.id.offlinecard)

        businessCateg=findViewById(R.id.userfullname)
        market=findViewById(R.id.platform)

        beginner=findViewById(R.id.beginner)
        medium=findViewById(R.id.intermediate)
        expert=findViewById(R.id.expert)

        var typeinfo : String = "online"
        val categoryinfo : String = businessCateg.text.toString()
        val platforminfo : String = market.text.toString()
        var levelinfo : String = "beginner"
        //val userId = firebaseDatabase

        onlinecard.setOnClickListener {
            typeinfo = "online"
            onlinecard.setBackgroundColor(resources.getColor(R.color.gulabi))
        }

        offlinecard.setOnClickListener {
            typeinfo = "offline"
            offlinecard.setBackgroundColor(resources.getColor(R.color.gulabi))
        }

        beginner.setOnClickListener {
            levelinfo = "beginner"
            beginner.setBackgroundColor(resources.getColor(R.color.gulabi))
            shownextbutton()
        }

        medium.setOnClickListener {
            levelinfo = "intermediate"
            medium.setBackgroundColor(resources.getColor(R.color.gulabi))
            shownextbutton()
        }

        expert.setOnClickListener {
            levelinfo = "expert"
            expert.setBackgroundColor(resources.getColor(R.color.gulabi))
            shownextbutton()
        }

        nextbtn.setOnClickListener {
            writeNewData(
                typeinfo, categoryinfo, platforminfo, levelinfo
            )
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }


    }

    private fun writeNewData(
        typeinfo: String,
        categoryinfo: String,
        platforminfo: String,
        levelinfo: String
    ) {
        val userinfo = userInfo(typeinfo, categoryinfo, platforminfo, levelinfo)

        database.child("userDetails").child("BusinessType").setValue(typeinfo)
        database.child("userDetails").child("categoryType").setValue(categoryinfo)
        database.child("userDetails").child("PlatformInfo").setValue(platforminfo)
        database.child("userDetails").child("UserLevel").setValue(levelinfo)
    }

    private fun shownextbutton() {
        nextbtn.visibility = View.VISIBLE
    }
}