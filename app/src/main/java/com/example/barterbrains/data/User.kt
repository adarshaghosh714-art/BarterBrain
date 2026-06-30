package com.example.barterbrains.data

data class User(

    val id: String = "",

    val fullName: String = "",

    val bio: String = "",

    val profileImageUrl: String = "",

    val skillsHave: List<String> = emptyList(),

    val skillsWant: List<String> = emptyList(),

    val location: String = ""

)