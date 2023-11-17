package com.example.canutoapp.ui.register

import android.content.Intent
import com.example.canutoapp.R
import com.example.canutoapp.databinding.FragmentRegister1Binding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.canutoapp.ui.login.LoginActivity

class Register1Fragment : Fragment() {

    private var binding: FragmentRegister1Binding? = null

    private val galeryResourceCode: Int = 200

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegister1Binding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClick()
    }

    private fun setupClick(){

        binding!!.btnIrCadastro2.setOnClickListener {
            findNavController().navigate(R.id.action_register1Fragment_to_registerTokenFragment)
        }

        binding!!.toolbar.setOnClickListener {
            val intent = Intent (requireContext(), LoginActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}