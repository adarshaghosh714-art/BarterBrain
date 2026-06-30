package com.example.barterbrains.data

data class Message(
    val messageId: String = "",
    val senderId:String ="",
    val receiverId:String ="",
    val text: String = "",
    val timestamp: Long = System.currentTimeMillis()
)
