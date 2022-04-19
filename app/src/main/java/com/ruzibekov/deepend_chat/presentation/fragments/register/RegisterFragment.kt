package com.ruzibekov.deepend_chat.presentation.fragments.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.ruzibekov.deepend_chat.R
import com.ruzibekov.deepend_chat.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment(R.layout.fragment_register) {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()
        binding.ivUserPhotoRegister.setOnClickListener { getImageFromStorage() }
        binding.buttonRegister.setOnClickListener { registerNewUser() }
        binding.tvLogin.setOnClickListener { findNavController().navigate(R.id.action_registerFragment_to_loginFragment) }
    }

    private val getAndSetImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            binding.ivUserPhotoRegister.setImageURI(it.data?.data)
        }

    private fun registerNewUser() {
        val username = binding.etRegisterUsername.text.toString().trim()
        val email = binding.etRegisterEmail.text.toString().trim()
        val password = binding.etRegisterPassword.text.toString().trim()
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, "Enter credentials", Toast.LENGTH_SHORT).show()
        } else {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    firestore.collection("users").add(mapOf(
                        "email" to email,
                        "image" to 123,
                        "username" to username
                    ))
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                }
                .addOnCanceledListener {
                    Toast.makeText(context, "User register cancelled", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun getImageFromStorage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        getAndSetImageResult.launch(intent)
    }


}