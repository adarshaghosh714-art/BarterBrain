package com.example.barterbrains.data





object DummyData {

    val users = listOf(

        User(
            id = "1",
            fullName = "Alex Rivera",
            bio = "Graphic designer and logo artist",
            skillsHave = listOf("Graphic Design", "Logo Design"),
            skillsWant = listOf("Kotlin", "Android"),
            location = "Portland"
        ),

        User(
            id = "2",
            fullName = "Sophia Lee",
            bio = "Android developer learning UI/UX",
            skillsHave = listOf("Kotlin", "Firebase"),
            skillsWant = listOf("UI Design"),
            location = "New York"
        )
    )
}