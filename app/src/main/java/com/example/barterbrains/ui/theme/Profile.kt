package com.example.barterbrains.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.barterbrains.R
import com.example.barterbrains.data.User

private val Background = Color(0xFFF5F6FA)
private val PrimaryGreen = Color(0xFF006D5B)
private val LightGreen = Color(0xFFDDF4EF)
private val LightOrange = Color(0xFFFFE3D3)
private val OrangeText = Color(0xFFCC6B2C)

@Composable
fun profileScreen(user: User,
                  navController: NavHostController
) {
    Scaffold(
        containerColor = Background,
        bottomBar = {
            BottomSaveButton()
        }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            ProfileImageSection()

            Spacer(modifier = Modifier.height(24.dp))

            ProfileTextField(
                label = "Full Name",
                value = user.fullName
            )
            Spacer(modifier = Modifier.height(16.dp))

            BioField(
                bio = user.bio
            )
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SkillCard(
                    title = "Skills I Have",
                    skills = user.skillsHave,
                    background = LightGreen,
                    chipColor = PrimaryGreen,
                    textColor = Color.White,
                    modifier = Modifier.weight(1f)
                )


                SkillCard(
                    title = "Skills I Want",
                    skills = user.skillsWant,
                    background = LightOrange,
                    chipColor = Color(0xFFFFC9A9),
                    textColor = OrangeText,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(100.dp))
        }

    }
}

@Composable
fun ProfileImageSection() {
    Box(contentAlignment = Alignment.BottomEnd) {
        Image(
            painter = painterResource(id = R.drawable.profile_default_ic),
            contentDescription = null,
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .background(PrimaryGreen),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }

    }
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = "Change Profile Photo",
        fontSize = 13.sp,
        color = Color.Gray
    )
}

@Composable
fun ProfileTextField(
    label: String,
    value: String
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            value = value,
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            singleLine = true,
            readOnly = true
        )
    }

}
@Composable
fun BioField(
    bio: String
){
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Text(
            text = "Bio",
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray

        )
        Spacer(modifier = Modifier.height(6.dp))
        OutlinedTextField(
            value = bio,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp),
            shape = RoundedCornerShape(14.dp),
            readOnly = true
        )
    }
}

@Composable
fun SkillCard(
    title: String,
    skills: List<String>,
    background: Color,
    chipColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = background
        )
    ) {

        Column(
            modifier = Modifier.padding(14.dp)
        ) {

            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(12.dp))

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                skills.forEach { skill ->

                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .background(chipColor)
                            .padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = skill,
                            color = textColor,
                            fontSize = 12.sp
                        )

                        Spacer(modifier = Modifier.size(4.dp))

                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = null,
                            tint = textColor,
                            modifier = Modifier.size(14.dp)
                        )
                    }
                }

                TextButton(
                    onClick = {}
                ) {
                    Text(text = "+ Add Skill")
                }
            }
        }
    }
}

@Composable
fun LocationCard(
    location: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF7D6)
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFFFD84D)),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = Color.Black
                )
            }

            Spacer(modifier = Modifier.size(14.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "Primary Location",
                    fontSize = 12.sp,
                    color = Color.DarkGray
                )

                Text(
                    text = location,
                    fontWeight = FontWeight.SemiBold
                )
            }

            TextButton(
                onClick = {}
            ) {
                Text("Change")
            }
        }
    }
}



@Composable
fun BottomSaveButton() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
    ) {

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryGreen
            )
        ) {

            Text(
                text = "Save Changes",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}



