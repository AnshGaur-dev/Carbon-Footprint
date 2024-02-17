package com.example.kriiyetahackathon.appactivies

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bharatyatrisathi.utils.USER_EMISSION
import com.example.bharatyatrisathi.utils.USER_NODE
import com.example.kriiyetahackathon.R
import com.example.kriiyetahackathon.databinding.ActivityGoalBinding
import com.example.kriiyetahackathon.model.EmissionData
import com.example.kriiyetahackathon.model.UserModel
import com.example.kriiyetahackathon.recyclerview.RecycleViewAdapter
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class GoalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGoalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityGoalBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        var username: String
        val emission: String = ""
        val currentUser = Firebase.auth.currentUser
        if (currentUser != null) {
            Firebase.firestore.collection(USER_NODE).document(currentUser.uid).get().addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    val user = documentSnapshot.toObject<UserModel>()
                    if (user != null) {
                        username = user.name.toString().trim()
                        binding.nametxt.text = user.name

                        // Update userEmission object with the fetched username

                        val userEmission = EmissionData(username = username, emission = emission)

                        Firebase.firestore.collection(USER_EMISSION)
                            .document(currentUser.uid).set(userEmission)
                            .addOnSuccessListener {
                                Log.d("GoalActivity", "User emission data updated successfully")
                            }.addOnFailureListener { e ->
                                Log.e("GoalActivity", "Error updating user emission data", e)
                            }
                    }
                }
            }
        }

        // navigation bar
        supportActionBar?.hide()
        binding.navigationDrawer.setBackgroundColor(Color.parseColor("#FFD698"))
        binding.navigationDrawer.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.cf -> {
                    startActivity(Intent(this, CFActivity::class.java))
                    finish()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.goal -> {
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false // Return false if none of the conditions match
        }
    }
}