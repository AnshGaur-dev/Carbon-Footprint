package com.example.kriiyetahackathon

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.kriiyetahackathon.appactivies.HomeActivity
import com.example.kriiyetahackathon.loginSIgnUp.Login_Activity
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            if (FirebaseAuth.getInstance().currentUser == null) {
                val iHome: Intent = Intent(
                    this@SplashActivity,
                    Login_Activity::class.java
                )
                startActivity(iHome)
            } else {
                val intent: Intent = Intent(
                    this@SplashActivity,
                    HomeActivity::class.java
                )
                startActivity(intent)
            }
        }, 1500)
    }
}