package com.paru.catchthekenny

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    var score:Int=0
    var imageArray=ArrayList<ImageView>()
    var handler:Handler=Handler()
    var runnable:Runnable= Runnable {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar=findViewById(R.id.toolbar)
        setUpToolbar()


        score=0

        imageArray= arrayListOf(imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9)

        hideImages()

        object : CountDownTimer(10000,1000)
        {
            override fun onFinish() {
                timeText.text="Time's Up"
                handler.removeCallbacks(runnable)
                for (image in imageArray)
                {
                    image.visibility=View.INVISIBLE
                }
                var intent= Intent(this@MainActivity,GameOver::class.java)
                intent.putExtra("Score",scoreText.text)
                startActivity(intent)
            }

            override fun onTick(millisUntilFinished: Long) {
                timeText.text="Time: "+ millisUntilFinished/1000
            }
        }.start()
    }

    fun hideImages()
    {
        runnable=object :Runnable{
            override fun run() {
                for (image in imageArray)
                {
                    image.visibility=View.INVISIBLE
                }
                 var random=Random()
                var index=random.nextInt(8-0)
                imageArray[index].visibility=View.VISIBLE
                handler.postDelayed(runnable,500)
            }
        }
            handler.post(runnable)
    }

    fun increaseScore(view: View)
    {
        score++

        scoreText.text= "Score: $score"
    }

    fun setUpToolbar()
    {
        setSupportActionBar(toolbar)
        supportActionBar?.title="Catch the Kenny"
    }
}
