package com.example.barterbrains.data

data class User(
    val fullName: String ="",
    val bio: String ="",
    val skillsHave:List<String> = emptyList(),
    val skillsWant:List<String> = emptyList()
)