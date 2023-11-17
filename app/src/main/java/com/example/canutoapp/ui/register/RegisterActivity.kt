package com.example.canutoapp.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.canutoapp.R
import com.example.canutoapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private var binding: ActivityRegisterBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater).apply { setContentView(root) }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}