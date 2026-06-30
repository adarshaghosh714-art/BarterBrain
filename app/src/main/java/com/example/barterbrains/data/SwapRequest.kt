package com.example.barterbrains.data

data class SwapRequest(
    val requestId:String="",
    val senderId:String="",
    val receiverId:String="",
    val offeredSkill:String="",
    val requestedSkill:String="",
    val status:String ="Pending"
)