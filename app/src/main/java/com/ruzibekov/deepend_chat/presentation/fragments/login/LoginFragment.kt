package com.ruzibekov.deepend_chat.presentation.fragments.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.ruzibekov.deepend_chat.R
import com.ruzibekov.deepend_chat.databinding.FragmentLoginBinding
import com.ruzibekov.deepend_chat.presentation.activity.user_email

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            user_email = auth.currentUser!!.email.toString()
            findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
        }
        binding.btnLogin.setOnClickListener { login() }
    }

    private fun login() {
        val email = binding.etLoginEmail.text.toString().trim()
        val password = binding.etLoginPassword.text.toString().trim()
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            }
            .addOnCanceledListener {
                Toast.makeText(context, "Login cancelled", Toast.LENGTH_SHORT).show()
            }
    }
}