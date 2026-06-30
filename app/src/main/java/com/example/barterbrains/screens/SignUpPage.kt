package com.example.barterbrains.screens



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun SignUp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFF5F6FA),
                        Color(0xFFEDE7F6)
                    )
                )
            )
            .padding(20.dp)
    ) {
        Header()
        Spacer(modifier = Modifier.height(20.dp))
        ProgressSection()
        Spacer(modifier = Modifier.height(20.dp))
        TitleSection()
        Spacer(modifier = Modifier.height(20.dp))
        Searchsection()
        Spacer(modifier = Modifier.height(20.dp))


        SkillCard(
            title = "Tech",
            chips = listOf(
                "Python",
                "Web Design",
                "Data Science",
                "App Development"
            ),
            chipColor = Color(0xFFDDF3F1),
            textColor = Color(0xFF00796B),
            selectedChip = "Web Design"
        )

        Spacer(modifier = Modifier.height(20.dp))

        SkillCard(
            title = "Creative",
            chips = listOf(
                "Digital Art",
                "Painting",
                "Photography",
                "Graphic Design"
            ),
            chipColor = Color(0xFFFBE8D8),
            textColor = Color(0xFFB35A00),
            selectedChip = "Pottery"
        )
        Spacer(modifier = Modifier.height(20.dp))
        SkillCard(
            title = " Cooking & Wellness",
            chips = listOf(
                "Meditation",
                "yoga",
                "Italian Cuisine",
                "Gardening"
            ),
            chipColor = Color(0xFFC7AF8B),
            textColor = Color(0xFFB96F3C),
            selectedChip = "Yoga"
        )

    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .statusBarsPadding(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = "Create Account",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF507D2A)
        )
    }
}

@Composable
fun ProgressSection() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Step 2 of 3",
                color = Color(0xFFE67E22),
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Skills and Expertise",
                color = Color.Gray
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        LinearProgressIndicator(
            progress = { 0.65f },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            color = Color(0xFF00897B),
            trackColor = Color(0xFFE5E7EB)
        )
    }
}

@Composable
fun TitleSection() {
    Column {
        Text(
            text = "What can you teach?",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0F172A)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Select the skills you are proficient in and willing to share.",
            fontSize = 16.sp,
            color = Color.Gray,
            lineHeight = 24.sp
        )
    }
}
@Composable
fun Searchsection() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(
                "Search or type a new skill"
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF00897B),
            unfocusedBorderColor = Color(0xFF00897B)
        )
    )
}

@Composable
fun SkillCard(
    title: String,
    chips: List<String>,
    chipColor: Color,
    textColor: Color,
    selectedChip: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(18.dp))

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                chips.forEach { chip ->

                    val isSelected = chip == selectedChip

                    Text(
                        text = chip,
                        modifier = Modifier
                            .background(
                                color = if (isSelected)
                                    textColor
                                else
                                    chipColor,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(
                                horizontal = 16.dp,
                                vertical = 10.dp
                            ),
                        color = if (isSelected)
                            Color.White
                        else
                            textColor
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SingupPreview() {
    SignUp()
}