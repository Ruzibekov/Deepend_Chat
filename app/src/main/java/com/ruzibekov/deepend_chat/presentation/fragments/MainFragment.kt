package com.ruzibekov.deepend_chat.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruzibekov.deepend_chat.R
import com.ruzibekov.deepend_chat.databinding.FragmentMainBinding
import com.ruzibekov.deepend_chat.models.LiveUserModel
import com.ruzibekov.deepend_chat.presentation.fragments.chats.ChatsLiveUsersAdapter

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
//        binding.recyclerLiveUsers.adapter = ChatsLiveUsersAdapter(getLiveUsersDatas())
    }

    private fun getLiveUsersDatas(): MutableList<LiveUserModel> {
        val liveUsers = mutableListOf<LiveUserModel>()
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground, username = "Ruzibekov_44", true))
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground, username = "Ruzibekov_44", true))
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground, username = "Ruzibekov_44", true))
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground, username = "Ruzibekov_44", true))
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground, username = "Ruzibekov_44", true))
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground, username = "Ruzibekov_44", true))
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground, username = "Ruzibekov_44", true))

        return liveUsers
    }
}