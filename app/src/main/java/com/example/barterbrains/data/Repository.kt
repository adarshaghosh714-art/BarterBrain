package com.example.barterbrains.data
class Repository {

    fun getUsers(): List<User> {
        return DummyData.users
    }
}