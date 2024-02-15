package com.example.kriiyetahackathon.loginSIgnUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Sms.Intents
import com.example.kriiyetahackathon.HomeActivity
import com.example.kriiyetahackathon.R
import com.example.kriiyetahackathon.databinding.ActivityLoginBinding

class Login_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginbutton.setOnClickListener{
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}