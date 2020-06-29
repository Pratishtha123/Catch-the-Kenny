package com.paru.catchthekenny

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomeActivity : AppCompatActivity() {

    lateinit var btnNew:Button
    lateinit var btnExit:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        btnExit=findViewById(R.id.btnExit)
        btnNew=findViewById(R.id.btnNew)

        btnNew.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        btnExit.setOnClickListener{
            finishAffinity()
        }
    }
}
