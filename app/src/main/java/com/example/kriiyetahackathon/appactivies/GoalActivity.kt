package com.example.kriiyetahackathon.appactivies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kriiyetahackathon.R
import com.example.kriiyetahackathon.databinding.ActivityGoalBinding

class GoalActivity : AppCompatActivity() {
    private lateinit var binding : ActivityGoalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityGoalBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.navigationDrawer.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.explore -> {
                    startActivity(Intent(this, CFActivity::class.java))
                    finish()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.profile -> {
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }


    }
}