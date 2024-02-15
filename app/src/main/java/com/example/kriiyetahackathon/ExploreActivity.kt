package com.example.kriiyetahackathon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kriiyetahackathon.databinding.ActivityExploreBinding

class ExploreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExploreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityExploreBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.navigationDrawer.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    finish()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false // Return false if none of the conditions match
        }


    }
}