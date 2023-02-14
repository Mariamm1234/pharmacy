package com.example.myapplication12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication12.databinding.ActivityChooseAccountTypeBinding

class chooseAccountType : AppCompatActivity() {
    lateinit var binding:ActivityChooseAccountTypeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_account_type)
        binding= ActivityChooseAccountTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var intent: Intent
        binding.patient.setOnClickListener {
            intent= Intent(this@chooseAccountType,MainActivity::class.java)
            intent.putExtra("type","${binding.patient.text}")
            startActivity(intent)
        }
        binding.doctor.setOnClickListener {
            intent= Intent(this@chooseAccountType,MainActivity::class.java)
            intent.putExtra("type","${binding.doctor.text}")
            startActivity(intent)
            finish()
        }
    }
    override fun onResume() {
        super.onResume()
        getSupportActionBar()?.hide()
    }
}