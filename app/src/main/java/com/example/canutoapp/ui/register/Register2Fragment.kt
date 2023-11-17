package com.example.canutoapp.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.canutoapp.R
import com.example.canutoapp.databinding.FragmentRegister2Binding


class Register2Fragment : Fragment() {

    private var _binding: FragmentRegister2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegister2Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()

    }

    private fun onClick() {
        binding?.toolbar?.setOnClickListener {
            findNavController().popBackStack()
        }

        binding?.confirmRegister?.setOnClickListener {
            findNavController().navigate(R.id.action_register2Fragment_to_register3Fragment)


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}