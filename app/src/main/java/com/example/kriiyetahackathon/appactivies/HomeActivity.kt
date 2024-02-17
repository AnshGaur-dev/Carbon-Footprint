package com.example.kriiyetahackathon.appactivies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bharatyatrisathi.utils.USER_EMISSION
import com.example.bharatyatrisathi.utils.USER_NODE
import com.example.kriiyetahackathon.R
import com.example.kriiyetahackathon.recyclerview.RecycleViewAdapter
import com.example.kriiyetahackathon.recyclerview.RecyclerViewArraylist
import com.example.kriiyetahackathon.databinding.ActivityHomeBinding
import com.example.kriiyetahackathon.model.EmissionData
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private lateinit var adapter: RecycleViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

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
            when (item.itemId) {
                R.id.cf -> {
                    startActivity(Intent(this, CFActivity::class.java))
                    finish()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.goal -> {
                    startActivity(Intent(this, GoalActivity::class.java))
                    finish()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.home -> {
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false // Return false if none of the conditions match
        }

//        Firebase.firestore.collection(USER_EMISSION).get().addOnSuccessListener { querySnapshot ->
//            val userList = mutableListOf<EmissionData>()
//            for (document in querySnapshot.documents) {
//                val user = document.toObject<EmissionData>()
//                if (user != null) {
//                    userList.add(user)
//                }
//            }
//            // Initialize RecyclerView and set adapter
//            val adapter = RecycleViewAdapter(userList)
//            binding.recycleView.adapter = adapter
//        }
        val arrContact = ArrayList<RecyclerViewArraylist>()
        arrContact.add(RecyclerViewArraylist(R.drawable.plant, "mic", "1234567891"))

        adapter = RecycleViewAdapter(this, arrContact)
        binding.recycleView.layoutManager = LinearLayoutManager(this)

    }
}