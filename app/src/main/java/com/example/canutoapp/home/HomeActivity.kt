package com.example.canutoapp.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.canutoapp.R
import com.example.canutoapp.databinding.ActivityHomeBinding
import com.example.canutoapp.databinding.ActivityLoginBinding
import com.example.canutoapp.ui.login.LoginActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }
        supportActionBar?.hide()

            binding.exitHome.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

        }

}