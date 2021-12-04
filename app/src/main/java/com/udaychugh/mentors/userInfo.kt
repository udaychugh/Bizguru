package com.udaychugh.mentors

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class userInfo(//val uid: String,
                    val typeInfo : String?= null,
                    val catInfo : String?= null,
                    val platInfo : String?=null,
                    val levelInfo : String?=null) {

}
