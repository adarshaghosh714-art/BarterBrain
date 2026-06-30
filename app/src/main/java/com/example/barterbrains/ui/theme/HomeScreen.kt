package com.example.barterbrains.ui.theme


import android.R.attr.onClick
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Doorbell
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.barterbrains.Navigation.Screen
import com.example.barterbrains.R
import com.example.barterbrains.data.User

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)

        ) {

            Spacer(modifier = Modifier.height(16.dp))

            HomeTopBar(navController = navController)

            Spacer(modifier = Modifier.height(24.dp))

            GreetingSection()

            Spacer(modifier = Modifier.height(24.dp))

            Searchsection()
            Spacer(modifier = Modifier.height(24.dp))
            FeaturedSkill()
            Spacer(modifier = Modifier.height(24.dp))
            PopularCategories()

        }
    }
}

@Composable
fun HomeTopBar(navController: NavHostController) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.profile_default_ic),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(50.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Barter Brains",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3D2CFF)
            )
            Spacer(modifier = Modifier.width(50.dp))
        }
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Inbox Icon",
            modifier = Modifier.size(24.dp)
                .clickable{
                    navController.navigate(Screen.Inbox.route)
                },
            tint = Color.Gray,

        )


    }
}

@Composable
fun GreetingSection() {
    Spacer(modifier = Modifier.height(24.dp))
    Column {
        Text(
            "Hello, Alex!",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "What do you want to learn today?",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3D2CFF)

        )

    }
}

@Composable
fun FeaturedSkill() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Featured Skills",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(100.dp))
                Text(
                    text = "See All",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF3D2CFF),
                    modifier = Modifier.clickable {

                        // action here

                    }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {

                items(5) {
                    SkillCard()
                }

            }


        }
    }
}

@Composable
fun SkillCard() {

    Card(
        modifier = Modifier
            .width(260.dp)
            .padding(top = 16.dp),

        shape = RoundedCornerShape(24.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {

        Column {

            Image(
                painter = painterResource(id = R.drawable.android_ic),
                contentDescription = "Skill Image",

                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),

                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Box(
                    modifier = Modifier
                        .background(
                            Color(0xFFFFE082),
                            RoundedCornerShape(12.dp)
                        )
                        .padding(
                            horizontal = 12.dp,
                            vertical = 6.dp
                        )
                ) {

                    Text(
                        text = "Creative",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "UI Design",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Learn advanced mobile UI design",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "By Alex Johnson",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF3D2CFF)
                )
            }
        }
    }
}

@Composable
fun PopularCategories() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
    ) {

        Text(
            text = "Popular Categories",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            CategoryCard(
                title = "Creative",
                backgroundColor = Color(0xFFEDE9FF),
                iconBackground = Color(0xFF3D2CFF)
            )

            CategoryCard(
                title = "Technical",
                backgroundColor = Color(0xFFDDF7EC),
                iconBackground = Color(0xFF006B3C)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            CategoryCard(
                title = "Lifestyle",
                backgroundColor = Color(0xFFFFEFD9),
                iconBackground = Color(0xFFA56A00)
            )

            CategoryCard(
                title = "Academic",
                backgroundColor = Color(0xFFEDEDED),
                iconBackground = Color(0xFF6B6B80)
            )
        }
    }
}

@Composable
fun CategoryCard(
    title: String,
    backgroundColor: Color,
    iconBackground: Color
) {

    Card(
        modifier = Modifier

            .height(120.dp),

        shape = RoundedCornerShape(24.dp),

        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(52.dp)
                    .background(
                        iconBackground,
                        RoundedCornerShape(16.dp)
                    ),

                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = title.first().toString(),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        }
    }
}

@Composable
fun BottomNavBar(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color.White,
                RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            )
            .padding(vertical = 16.dp),

        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavItem(
            title = "Home",
            icon = Icons.Default.Home,
            isSelected = false,
            onClick = { navController.navigate(Screen.Home.route) }
        )
        BottomNavItem(
            title = "Explore",
            icon = Icons.Default.Explore,
            isSelected = false,
            onClick = {
                navController.navigate(Screen.Explore.route)
            }
        )
        BottomNavItem(
            title = "Message",
            icon = Icons.Default.Email,
            isSelected = false,
            onClick = {
                navController.navigate(Screen.Chat.route)
            }
        )
        BottomNavItem(
            title = "Profile",

            icon = Icons.Default.Person,
            isSelected = false,
            onClick = {
                navController.navigate(Screen.Profile.route)
            }
        )
    }
}

@Composable
fun BottomNavItem(
    title: String,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable {
            onClick()
        }
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(
                    if (isSelected)
                        Color(0xFF3D2CFF)
                    else
                        Color(0xFFF1F1F1),
                    RoundedCornerShape(16.dp)

                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = if (isSelected) Color.White else Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = title,
            fontSize = 12.sp,
            color = if (isSelected)
                Color(0xFF3D2CFF)
            else
                Color.Gray,

            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun UserCard(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = user.profileImageUrl,

                contentDescription = "Profile Image",

                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),

                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = user.fullName,
                )
                Text(
                    text = user.bio

                )
                Text(
                    text = "Skills: ${user.skillsHave.joinToString()}"
                )
                Text(
                    text = "Skills: ${user.skillsWant.joinToString()}"
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {

    val navController = rememberNavController()

    HomeScreen(navController)
//UserCard(user = User())
}
