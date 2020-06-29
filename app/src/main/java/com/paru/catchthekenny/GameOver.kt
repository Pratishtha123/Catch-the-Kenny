package com.paru.catchthekenny

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game_over.*

class GameOver : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        score.text= intent.getStringExtra("Score")

        btnPlayAgain.setOnClickListener{
            val intent=Intent(this@GameOver,MainActivity::class.java)
            startActivity(intent)
        }

        btnHome.setOnClickListener{
            val intent=Intent(this@GameOver,WelcomeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
    }
}
