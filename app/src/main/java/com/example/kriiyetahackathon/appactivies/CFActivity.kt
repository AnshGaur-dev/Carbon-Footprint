package com.example.kriiyetahackathon.appactivies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kriiyetahackathon.R
import com.example.kriiyetahackathon.databinding.ActivityCfBinding

class CFActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCfBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityCfBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.navigationDrawer.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.goal -> {
                    startActivity(Intent(this, GoalActivity::class.java))
                    finish()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.cf -> {
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false // Return false if none of the conditions match
        }


    }
}