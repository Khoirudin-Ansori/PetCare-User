package com.example.petcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tosignup()
    }
    fun tosignup(){
        to_frm_signup.setOnClickListener(){
            val tosignup = Intent(this, SignUpActivity::class.java)
            startActivity(tosignup)
        }

    }
}
