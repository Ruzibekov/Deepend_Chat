package com.ruzibekov.deepend_chat.presentation.fragments.chats

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ruzibekov.deepend_chat.R
import com.ruzibekov.deepend_chat.databinding.FragmentChatsBinding
import com.ruzibekov.deepend_chat.models.ChatModel
import com.ruzibekov.deepend_chat.models.LiveUserModel
import com.ruzibekov.deepend_chat.presentation.activity.user_email

class ChatsFragment : Fragment(R.layout.fragment_chats) {
    private lateinit var binding: FragmentChatsBinding
    private lateinit var fireStoreDatabase: FirebaseFirestore

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChatsBinding.bind(view)
        fireStoreDatabase = Firebase.firestore
        binding.recyclerLiveUsers.adapter = ChatsLiveUsersAdapter(getLiveUsersDatas())
        getChats()
        binding.imgBtnAddChat.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_addContactFragment)
        }
    }

    private fun getLiveUsersDatas(): ArrayList<LiveUserModel> {
        val liveUsers = arrayListOf<LiveUserModel>()
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground,
            username = "Ruzibekov_44",
            true))
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground,
            username = "Ruzibekov_44",
            true))
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground,
            username = "Ruzibekov_44",
            true))
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground,
            username = "Ruzibekov_44",
            true))
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground,
            username = "Ruzibekov_44",
            true))
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground,
            username = "Ruzibekov_44",
            true))
        liveUsers.add(LiveUserModel(image = R.drawable.ic_launcher_foreground,
            username = "Ruzibekov_44",
            true))

        return liveUsers
    }

    private fun getChats() {
        fireStoreDatabase.collection("users").get().addOnSuccessListener { result ->
            addChat(result)
        }.addOnCanceledListener {
            Toast.makeText(context, "Please check the internet connection", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addChat(result: QuerySnapshot?) {
        val chats = arrayListOf<ChatModel>()
        Toast.makeText(context, "Users Loaded", Toast.LENGTH_SHORT).show()
        Log.i("mylog", user_email)
        for (item in result!!)
            if(item.data["email"]!! != user_email)
                chats.add(ChatModel(R.drawable.ic_launcher_background,
                    true,
                    item.data["username"].toString(),
                    item.data["email"].toString(),
                    "12:45",
                    5))
        binding.recyclerChatsMain.adapter = ChatsMainAdapter(chats)
    }
}