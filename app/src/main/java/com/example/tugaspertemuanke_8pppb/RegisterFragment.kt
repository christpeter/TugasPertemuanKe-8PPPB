package com.example.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.app.databinding.RegisterFragmentBinding
import com.example.tugaspertemuanke_8pppb.R

class RegisterFragment<RegisterFragmentBinding> : Fragment() {

    private lateinit var binding: RegisterFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RegisterFragmentBinding.inflate(inflater, container, false)

        binding.registerButton.setOnClickListener {
            val username = binding.usernameInput.text.toString()

            if (username.isNotEmpty()) {
                // Navigasi ke HomeFragment setelah register
                val action = RegisterFragmentDirections.actionRegisterFragmentToHomeFragment(username)
                findNavController().navigate(action)
            } else {
                Toast.makeText(activity, "Please enter username", Toast.LENGTH_SHORT).show()
            }
        }

        // Klik login, navigasi ke LoginFragment
        binding.loginLink.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

        return binding.root
    }
}
