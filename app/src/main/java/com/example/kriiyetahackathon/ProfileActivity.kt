package com.example.kriiyetahackathon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kriiyetahackathon.databinding.ActivityHomeBinding
import com.example.kriiyetahackathon.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.navigationDrawer.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.explore -> {
                    startActivity(Intent(this, ExploreActivity::class.java))
                    finish()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false // Return false if none of the conditions match
        }


    }
}