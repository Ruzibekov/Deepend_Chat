package com.ruzibekov.deepend_chat.models

data class ChatModel(
    val image: Int,
    val isOnline: Boolean,
    val username: String,
    val lastMessage: String,
    val lastMessageTime: String,
    val messagesCount: Int
)