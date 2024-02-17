package com.example.kriiyetahackathon.appactivies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kriiyetahackathon.R
import com.example.kriiyetahackathon.recyclerview.RecycleViewAdapter
import com.example.kriiyetahackathon.recyclerview.RecyclerViewArraylist
import com.example.kriiyetahackathon.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private lateinit var adapter: RecycleViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
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
                    startActivity(Intent(this, GoalActivity::class.java))
                    finish()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.home -> {
                    return@setOnNavigationItemSelectedListener true
                }

            }
            false
        }
        val arrContact = ArrayList<RecyclerViewArraylist>()
        arrContact.add(RecyclerViewArraylist(R.drawable.plant, "mic", "1234567891"))

        adapter = RecycleViewAdapter(this, arrContact)
        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = adapter







    }
}