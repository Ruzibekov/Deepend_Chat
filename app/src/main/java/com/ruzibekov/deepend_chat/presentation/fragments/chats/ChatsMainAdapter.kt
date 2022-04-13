package com.ruzibekov.deepend_chat.presentation.fragments.chats

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ruzibekov.deepend_chat.R
import com.ruzibekov.deepend_chat.databinding.ItemChatMainBinding
import com.ruzibekov.deepend_chat.models.ChatModel

class ChatsMainAdapter(private val chats: ArrayList<ChatModel>) :
    RecyclerView.Adapter<ChatsMainAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat_main, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = ItemChatMainBinding.bind(holder.itemView)
        binding.imageMainChat.setImageResource(chats[position].image)
        binding.textUsernameChat.text = chats[position].username
        binding.tvLastMessageText.text = chats[position].lastMessage
        binding.tvLastMessageTime.text = chats[position].lastMessageTime
        binding.tvMessageCount.text = chats[position].messagesCount.toString()
        binding.imageMainChat.borderColor =
            if (chats[position].isOnline)
                Color.GREEN
            else
                Color.WHITE

    }

    override fun getItemCount() = chats.size
}