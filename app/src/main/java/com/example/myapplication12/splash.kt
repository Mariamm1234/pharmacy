package com.example.myapplication12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import java.util.*
import kotlin.properties.Delegates

class splash : AppCompatActivity() {
     var islog :Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val shareorefrences = this.getSharedPreferences("app", MODE_PRIVATE)
        val editor = shareorefrences.edit()
        var isloged= shareorefrences.getBoolean("isLoged", false)
        if(islog==false)
            isloged=islog
        Timer().schedule(object : TimerTask() {
            override fun run() {
                if(isloged==true)
                    startActivity(Intent(applicationContext, home::class.java))
                else
                    startActivity(Intent(applicationContext, chooseAccountType::class.java))
//                if(isloged==true&& intent.getStringExtra("splas")=="Sign Up Customer")
//                    startActivity(Intent(applicationContext, home::class.java))
//                else
//                    startActivity(Intent(applicationContext, choose::class.java))
//                if(isloged==true&& intent.getStringExtra("splas")=="Sign Up Admin")
//                    startActivity(Intent(applicationContext, admainpage::class.java))
//                else
//                    startActivity(Intent(applicationContext, choose::class.java))
            }
        }, 3000)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== RESULT_OK)
        { var x=data!!.getStringExtra("isloged")
            islog=x.toBoolean()
//        isloged=x.toBoolean()
        }
    }
    override fun onResume() {
        super.onResume()
        var logo: TextView = findViewById(R.id.logo)
        val animationBounce = AnimationUtils.loadAnimation(this, R.anim.bounce)
        logo.startAnimation(animationBounce)
        getSupportActionBar()?.hide()
    }
}
