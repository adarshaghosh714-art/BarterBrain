package com.example.barterbrains.Navigation

sealed class Screen(val route: String){
    object Home:Screen("home")
    object Explore:Screen("explore")
    object Profile:Screen("profile")
    object Chat:Screen("chat")
    object Inbox:Screen("inbox")
}