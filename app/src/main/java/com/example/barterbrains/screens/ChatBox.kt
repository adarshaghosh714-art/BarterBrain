package com.example.barterbrains.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.InsertEmoticon
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun ChatScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {


        ChatTopBar()


        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {

            item {
                DateDivider()
            }

            item {
                ChatBubble(
                    message = "I'd love to trade my AI expertise for your UI design skills!",
                    time = "10:45 AM",
                    profileImage = R.drawable.profile_default_ic
                )
            }

            item {
                ProposalReview(
                    offerdSkill = "AI",
                    requestedSkill = "UI"
                )
            }

            item {
                SenderBubble(
                    message = "That sounds great! Let's discuss the details.",
                    time = "10:47 AM"
                )
            }
        }
        BottomInput(
            modifier = Modifier
                .fillMaxWidth()
                .imePadding()
        )
    }
}

@Composable
fun ChatTopBar(
    onBackClick: () -> Unit = {},
    onInfoClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {


        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier
                .size(28.dp)
                .clickable { onBackClick() },
            tint = Color.Black
        )

        Spacer(modifier = Modifier.width(12.dp))


        Box {

            Image(
                painter = painterResource(id = R.drawable.profile_default_ic),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .size(14.dp)
                    .align(Alignment.BottomEnd)
                    .clip(CircleShape)
                    .background(Color(0xFF2ECC71))
                    .border(2.dp, Color.White, CircleShape)
            )
        }

        Spacer(modifier = Modifier.width(12.dp))


        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = "Dr. Elena Rossi",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "COGNITIVE SCIENTIST",
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray,
                letterSpacing = 1.sp
            )
        }


        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = "Info",
            modifier = Modifier
                .size(28.dp)
                .clickable { onInfoClick() },
            tint = Color.Black
        )
    }
}

@Composable
fun DateDivider(
    date: String = "Today"
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = 1.dp,
            color = Color(0xFFE0E0E0)
        )
        Text(
            text = date,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 12.dp),
            color = Color.Gray
        )
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = 1.dp,
            color = Color(0xFFE0E0E0)
        )
    }
}

@Composable
fun ChatBubble(
    message: String,
    time: String,
    profileImage: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        Image(
            painter = painterResource(id = profileImage),
            contentDescription = "Profile",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Box(
                modifier = Modifier
                    .background(
                        Color(0xFFF3F3F3),
                        RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp,
                            bottomEnd = 16.dp,
                            bottomStart = 4.dp
                        )

                    )
                    .padding(16.dp)
            ) {
                Text(
                    text = message,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = time,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }

    }

}

@Composable
fun ProposalReview(
    offerdSkill: String,
    requestedSkill: String,
    onReviewClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF8F7FF)
        ),
        elevation = CardDefaults.cardElevation(
            2.dp
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.SwapHoriz,
                    contentDescription = null,
                    tint = Color(0xFF3D2CFF)
                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Swap Proposal",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
            Text(
                text = "You offer",
                fontSize = 12.sp,
                color = Color.Gray
            )
            Text(
                text = offerdSkill,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "You recieve",
                fontSize = 12.sp,
                color = Color.Gray
            )
            Text(
                text = requestedSkill,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = onReviewClick,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3D2CFF)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Review Proposal",
                    color = Color.White

                )
            }

        }
    }
}

@Composable
fun SenderBubble(
    message: String,
    time: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {

        Column(
            horizontalAlignment = Alignment.End
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .background(
                        Color(0xFF3D2CFF),
                        RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp,
                            bottomStart = 16.dp,
                            bottomEnd = 4.dp
                        )
                    )
                    .padding(16.dp)
            ) {

                Text(
                    text = message,
                    color = Color.White,
                    fontSize = 15.sp
                )

            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "$time • You",
                fontSize = 12.sp,
                color = Color.Gray
            )

        }

    }

}
@Composable
fun BottomInput(
    modifier: Modifier = Modifier
) {

    var message by remember {
        mutableStateOf("")
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {


        IconButton(
            onClick = { }
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Attachment",
                tint = Color(0xFF3D2CFF)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))


        OutlinedTextField(
            value = message,
            onValueChange = {
                message = it
            },
            modifier = Modifier.weight(1f),
            placeholder = {
                Text("Type a message...")
            },
            shape = RoundedCornerShape(24.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.width(8.dp))


        IconButton(
            onClick = { }
        ) {
            Icon(
                imageVector = Icons.Default.InsertEmoticon,
                contentDescription = "Emoji",
                tint = Color.Gray
            )
        }


        FloatingActionButton(
            onClick = {

            },
            containerColor = Color(0xFF3D2CFF),
            modifier = Modifier.size(52.dp)
        ) {

            Icon(
                imageVector = Icons.AutoMirrored.Filled.Send,
                contentDescription = "Send",
                tint = Color.White
            )

        }

    }
}
//@Preview
//@Composable
//fun ChatScreenPreview(){
//    ChatScreen()
//}
//
