package com.example.new_api_kotlin.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.new_api_kotlin.R

class DetailsUserActivity :AppCompatActivity(){

    private lateinit var detailsUserId:TextView
    private lateinit var detailsUserEmail:TextView
    private lateinit var detailsUserFirstName:TextView
    private lateinit var detailsUserLastName:TextView
    private lateinit var detailsUserImage:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_user)
        detailsUserId=findViewById(R.id.detailsUserId)
        detailsUserEmail=findViewById(R.id.detailsUserEmail)
        detailsUserFirstName=findViewById(R.id.detailUserFirstName)
        detailsUserLastName=findViewById(R.id.detailsUserLastName)
        detailsUserImage=findViewById(R.id.detailUserImg)

        val image=intent.getStringExtra("avatar")
      //  detailsUserImage.setImageURI(image)

        val id=intent.getStringExtra("id")
        detailsUserId.setText(id)

        val email=intent.getStringExtra("email")
        detailsUserEmail.setText(email)

        val firstname=intent.getStringExtra("firstname")
        detailsUserFirstName.setText(firstname)

        val lastname=intent.getStringExtra("lastname")
        detailsUserLastName.setText(lastname)
    }
}

