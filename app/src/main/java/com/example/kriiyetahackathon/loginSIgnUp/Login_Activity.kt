package com.example.kriiyetahackathon.loginSIgnUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.example.kriiyetahackathon.appactivies.HomeActivity
import com.example.kriiyetahackathon.databinding.ActivityLoginBinding
import com.example.kriiyetahackathon.model.UserModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.loginbutton.setOnClickListener {
            if (binding.email.editableText?.toString()!!.isEmpty() or
                binding.password.editableText?.toString()!!.isEmpty()
            ){
                Toast.makeText(this@Login_Activity,
                    "Please Fill the Details",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                val user = UserModel (binding.email.editableText?.toString()!!,
                    binding.password.editableText?.toString()!!)

                Firebase.auth.signInWithEmailAndPassword(user.email!!, user.password!!)
                    .addOnCompleteListener{
                        if (it.isSuccessful){
                            startActivity(Intent(this@Login_Activity, HomeActivity::class.java))
                            finish()
                        }else{
                            Toast.makeText(this@Login_Activity, it.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
                        }

                    }
            }
        }
        binding.signupbutton.setOnClickListener{
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}