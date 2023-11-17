package com.example.canutoapp.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.canutoapp.R
import com.example.canutoapp.databinding.FragmentRegisterTokenBinding
import com.google.android.material.textfield.TextInputEditText
class RegisterTokenFragment : Fragment() {

    private var binding: FragmentRegisterTokenBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterTokenBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
        setupLayout()
    }

    private fun setupLayout() {
        val editText1 = binding?.typeValidLayout?.findViewById<TextInputEditText>(R.id.second1_input_digit)
        val editText2 = binding?.typeValidLayout?.findViewById<TextInputEditText>(R.id.second_input_digit)
        val editText3 = binding?.typeValidLayout?.findViewById<TextInputEditText>(R.id.third_input_digit)
        val editText4 = binding?.typeValidLayout?.findViewById<TextInputEditText>(R.id.fourth_input_digit)

        editText1?.doOnTextChanged { text, start, before, count ->
            editText2?.requestFocus()
        }
        editText2?.doOnTextChanged { text, start, before, count ->
            editText3?.requestFocus()
        }
        editText3?.doOnTextChanged { text, start, before, count ->
            editText4?.requestFocus()
        }

    }

    private fun onClick() {
        binding?.toolbar?.setOnClickListener {
            findNavController().popBackStack()
        }

        binding?.irRegister2?.setOnClickListener {
            findNavController().navigate(R.id.action_registerTokenFragment_to_register2Fragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
