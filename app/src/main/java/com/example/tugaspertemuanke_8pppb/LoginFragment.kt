package com.example.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.app.databinding.LoginFragmentBinding
import com.example.tugaspertemuanke_8pppb.R

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater, container, false)

        binding.loginButton.setOnClickListener {
            val username = binding.usernameInput.text.toString()

            if (username.isNotEmpty()) {
                // Navigasi ke HomeFragment setelah login
                val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment(username)
                findNavController().navigate(action)
            } else {
                Toast.makeText(activity, "Please enter username", Toast.LENGTH_SHORT).show()
            }
        }

        // Klik register, navigasi ke RegisterFragment
        binding.registerLink.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        return binding.root
    }
}
