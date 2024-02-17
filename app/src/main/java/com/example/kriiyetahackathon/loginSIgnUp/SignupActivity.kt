package com.example.kriiyetahackathon.loginSIgnUp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bharatyatrisathi.utils.USER_NODE
import com.example.kriiyetahackathon.appactivies.HomeActivity
import com.example.kriiyetahackathon.databinding.ActivitySignupBinding
import com.example.kriiyetahackathon.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignupActivity : AppCompatActivity() {

    lateinit var user: UserModel

    val binding by lazy {
        ActivitySignupBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        user = UserModel()

        binding.signupbutton.setOnClickListener {
            if (binding.name.editableText?.toString().isNullOrBlank() ||
                binding.email.editableText?.toString().isNullOrBlank() ||
                binding.password.editableText?.toString().isNullOrBlank()
            ) {
                Toast.makeText(this@SignupActivity, "Please fill all the details", Toast.LENGTH_SHORT).show()
            } else {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.email.editableText.toString(),
                    binding.password.editableText.toString()
                ).addOnCompleteListener { result ->
                    if (result.isSuccessful) {
                        user.name = binding.name.editableText.toString()
                        user.password = binding.password.editableText.toString()
                        user.email = binding.email.editableText.toString()

                        Firebase.firestore.collection(USER_NODE)
                            .document(Firebase.auth.currentUser!!.uid)
                            .set(user)
                            .addOnSuccessListener {
                                Log.d("SignupActivity", "User data added successfully to Firestore")
                                startActivity(Intent(this@SignupActivity, HomeActivity::class.java))
                                finish()
                            }.addOnFailureListener { e ->
                                Log.e("SignupActivity", "Error adding user data to Firestore", e)
                                Toast.makeText(
                                    this@SignupActivity,
                                    "Error: ${e.message}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                    } else {
                        Log.e("SignupActivity", "Error creating user", result.exception)
                        Toast.makeText(
                            this@SignupActivity,
                            "Error: ${result.exception?.localizedMessage}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}