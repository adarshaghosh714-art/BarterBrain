package com.example.barterbrains.screens

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.barterbrains.R
import com.example.barterbrains.data.dummyinboxData

val inboxList = listOf(
    dummyinboxData(
        profileImage = R.drawable.profile_default_ic,
        name = "Adarsha Ghosh",
        profession = "COGNITIVE SCIENTIST",
        message = "I would love to trade my research...",
        time = "2m ago",
        unreadCount = 1,
        isOnline = true
    )
)

@Composable
fun InboxScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            InboxTopBar()
            Spacer(modifier = Modifier.height(24.dp))
            FilterChips()
            Spacer(modifier = Modifier.height(24.dp))
            InboxList(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun InboxTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo",
            modifier = Modifier.size(36.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Inbox",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3D2CFF)
        )
        Spacer(modifier = Modifier.weight((1f)))

        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Inbox Search",
            modifier = Modifier
                .size(24.dp)
                .clickable {

                },
            tint = Color.Gray

        )
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = painterResource(id = R.drawable.profile_default_ic),
            contentDescription = "Logo",
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }

}

@Composable
fun FilterChips() {
    var selectedFilter by remember {
        mutableStateOf("ALL")
    }
    val filters = listOf(
        "All", "Unseen", "Read"
    )
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(filters) { filter ->
            var isSelected = filter == selectedFilter
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        if (isSelected)
                            Color(0xFF3D2CFF)
                        else
                            Color(0xFFF3F3F3)
                    )
                    .clickable {
                        selectedFilter = filter
                    }
                    .padding(
                        horizontal = 20.dp,
                        vertical = 10.dp
                    )

            ) {
                Text(
                    text = filter,
                    color = if (isSelected)
                        Color.White
                    else
                        Color.Gray,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
@Composable
fun InboxList(modifier: Modifier= Modifier){
    LazyColumn(modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)) {
        items(inboxList){
            item->
            InboxListitem(item = item)
        }
    }
}


@Composable
fun InboxListitem(item: dummyinboxData) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Image(
            painter = painterResource(id = item.profileImage),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = item.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Text(
                text = item.profession,
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.message,
                maxLines = 1,
                color = Color.DarkGray
            )
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text =item.time,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                if(item.unreadCount>0){
                    Box(
                        modifier = Modifier.size(24.dp)
                            .background(Color(0xFF3D2CFF),
                                CircleShape),
                        contentAlignment = Alignment.Center){
                        Text(
                            text = item.unreadCount.toString(),
                            color = Color.White,
                            fontSize = 12.sp
                        )

                    }

                }
            }
        }
    }
}


@Preview
@Composable
fun InboxPreview() {
    InboxScreen(navController = rememberNavController())
}

