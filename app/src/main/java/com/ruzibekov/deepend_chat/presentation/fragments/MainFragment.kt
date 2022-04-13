package com.ruzibekov.deepend_chat.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ruzibekov.deepend_chat.R
import com.ruzibekov.deepend_chat.databinding.FragmentMainBinding
import com.ruzibekov.deepend_chat.presentation.fragments.chats.ChatsFragment
import com.ruzibekov.deepend_chat.presentation.fragments.profile.ProfileFragment

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        setFragment(ChatsFragment())

        binding.bottomNavMain.setOnItemSelectedListener {
            when (it.title) {
                "Chats" -> setFragment(ChatsFragment())
//                "Groups" -> setFragment(GroupsFragment())
                "Profile" -> setFragment(ProfileFragment())
            }
            true
        }
    }

    private fun setFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_main_fragment, fragment).commit()
    }
}