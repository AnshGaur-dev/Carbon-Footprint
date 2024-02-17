package com.example.kriiyetahackathon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kriiyetahackathon.appactivies.HomeActivity
import com.example.kriiyetahackathon.databinding.ActivityLoginBinding
import com.example.kriiyetahackathon.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_signup)
        setContentView(binding.root)
        binding.signupbutton.setOnClickListener{
            val name = binding.namesignup.text.toString().trim()
            val password = binding.passwordsignup.text.toString().trim()
            val email = binding.emailsignup.text.toString().trim()
            val username = binding.usernamesignup.text.toString().trim()


            if (name.isNotEmpty() && password.isNotEmpty()&&username.isNotEmpty()&&email.isNotEmpty()) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Please provide all the required data", Toast.LENGTH_SHORT).show()
            }
        }




    }
}