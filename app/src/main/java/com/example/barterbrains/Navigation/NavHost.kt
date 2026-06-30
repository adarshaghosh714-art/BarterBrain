package com.example.barterbrains.Navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.barterbrains.data.User
import com.example.barterbrains.screens.BottomNavBar
import com.example.barterbrains.screens.ChatScreen
import com.example.barterbrains.screens.HomeScreen
import com.example.barterbrains.screens.InboxScreen
import com.example.barterbrains.screens.profileScreen

@Composable
fun BarterBrainsApp() {

    val navController = rememberNavController()

    Scaffold(

        bottomBar = {
            BottomNavBar(navController)
        }

    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(padding)
        ) {

            composable(Screen.Home.route) {
                HomeScreen(navController)
            }
            composable(Screen.Inbox.route) {
                InboxScreen(navController)
            }

//            composable(Screen.Explore.route) {
//                ExploreScreen(navController)
//            }
//
            composable(Screen.Profile.route) {

                val sampleUser = User(
                    fullName = "Alex Johnson",
                    bio = "Android Developer"
                )

                profileScreen(
                    user = sampleUser,
                    navController = navController
                )
            }
            composable(Screen.Chat.route) {
                ChatScreen(navController)
            }
        }

        }
    }


