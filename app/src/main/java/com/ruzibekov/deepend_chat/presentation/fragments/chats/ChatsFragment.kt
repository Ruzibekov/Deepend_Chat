package com.ruzibekov.deepend_chat.presentation.fragments.chats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruzibekov.deepend_chat.R
import com.ruzibekov.deepend_chat.databinding.FragmentChatsBinding
import com.ruzibekov.deepend_chat.models.ChatModel
import com.ruzibekov.deepend_chat.models.LiveUserModel

class ChatsFragment : Fragment(R.layout.fragment_chats) {
    private lateinit var binding: FragmentChatsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChatsBinding.bind(view)
        binding.recyclerLiveUsers.adapter = ChatsLiveUsersAdapter(getLiveUsersDatas())
        binding.recyclerChatsMain.adapter = ChatsMainAdapter(getChats())
    }


    private fun getLiveUsersDatas(): ArrayList<LiveUserModel> {
        val liveUsers = arrayListOf<LiveUserModel>()
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground, username = "Ruzibekov_44", true))
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground, username = "Ruzibekov_44", true))
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground, username = "Ruzibekov_44", true))
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground, username = "Ruzibekov_44", true))
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground, username = "Ruzibekov_44", true))
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground, username = "Ruzibekov_44", true))
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground, username = "Ruzibekov_44", true))

        return liveUsers
    }

    private fun getChats(): ArrayList<ChatModel>{
        val chats = arrayListOf<ChatModel>()
        chats.add(ChatModel(R.drawable.ic_launcher_background, true, "Shavkatbek", "Qayerlarda yuribsan?", "12:45", 5))
        chats.add(ChatModel(R.drawable.ic_launcher_background, false, "Shavkatbek", "Qayerlarda yuribsan?", "12:45", 5))
        chats.add(ChatModel(R.drawable.ic_launcher_background, false, "Shavkatbek", "Qayerlarda yuribsan?", "12:45", 5))
        chats.add(ChatModel(R.drawable.ic_launcher_background, false, "Shavkatbek", "Qayerlarda yuribsan?", "12:45", 5))
        chats.add(ChatModel(R.drawable.ic_launcher_background, false, "Shavkatbek", "Qayerlarda yuribsan?", "12:45", 5))
        chats.add(ChatModel(R.drawable.ic_launcher_background, false, "Shavkatbek", "Qayerlarda yuribsan?", "12:45", 5))
        chats.add(ChatModel(R.drawable.ic_launcher_background, false, "Shavkatbek", "Qayerlarda yuribsan?", "12:45", 5))
        chats.add(ChatModel(R.drawable.ic_launcher_background, false, "Shavkatbek", "Qayerlarda yuribsan?", "12:45", 5))
        chats.add(ChatModel(R.drawable.ic_launcher_background, false, "Shavkatbek", "Qayerlarda yuribsan?", "12:45", 5))
        chats.add(ChatModel(R.drawable.ic_launcher_background, false, "Shavkatbek", "Qayerlarda yuribsan?", "12:45", 5))
        chats.add(ChatModel(R.drawable.ic_launcher_background, false, "Shavkatbek", "Qayerlarda yuribsan?", "12:45", 5))
        chats.add(ChatModel(R.drawable.ic_launcher_background, false, "Shavkatbek", "Qayerlarda yuribsan?", "12:45", 5))
        return chats
    }
}