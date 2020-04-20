package com.example.petcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        to_login()
    }

    fun to_login(){
        to_frm_login.setOnClickListener(){
            val tologin = Intent(this, MainActivity::class.java)
            startActivity(tologin)
        }

    }
}
