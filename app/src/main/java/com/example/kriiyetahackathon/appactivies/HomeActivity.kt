package com.example.kriiyetahackathon.appactivies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import android.os.CountDownTimer
import android.widget.ProgressBar
=======
>>>>>>> 42442b2b43f9c2036e7c0d4961f6b6d6c3a97ff9
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
<<<<<<< HEAD
        var Currentprogress=0
//        var countDownTimer=object : CountDownTimer(11*1000, 1000) {
//
//
//            override fun onTick(millisUntilFinished: Long) {
//                Currentprogress = Currentprogress*10
//                binding.progressBar.setProgress(Currentprogress)
//                binding.progressBar.setMax(100)
//
//            }
//
//            override fun onFinish() {
//            }
//        }
//        countDownTimer.start()

            binding.navigationDrawer.setOnNavigationItemSelectedListener { item ->
=======

        binding.navigationDrawer.setOnNavigationItemSelectedListener { item ->
>>>>>>> 42442b2b43f9c2036e7c0d4961f6b6d6c3a97ff9
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