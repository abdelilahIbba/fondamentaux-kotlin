package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen() {
    // State to hold the result for random image selection
    var result by remember { mutableStateOf(1) }

    // Description for the image
    var description by remember { mutableStateOf("Porte de Bab el-Mansour") }

    // Fixed background image resource
    val backgroundImageResource = R.drawable.babelmansour

    // Random selection for profile image and description
    val profileImageResource = when (result) {
        1 -> R.drawable.babelmansour
        2 -> R.drawable.mausol_e_my_ismail
        3 -> R.drawable.bab_el_mansour
        else -> R.drawable.babelmansour
    }

    // Using a Box to stack the background image and content
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background image
        Image(
            painter = painterResource(id = backgroundImageResource),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop,
        )

        // Adding a gradient overlay for better readability
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.7f)
                        )
                    )
                )
        )

        // Overlaying content on top of the background image
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Profile image
            Image(
                painter = painterResource(id = profileImageResource),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )

            // Name and title section
            Greeting(description, modifier = Modifier.padding(vertical = 16.dp))

            // Contact info section
            ContactInfo()

            // Button to change profile image and description randomly
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                result = (1..3).random() // Randomly change the profile image
                description = when (result) {
                    1 -> "Porte de Bab el-Mansour"
                    2 -> "Mausoleum of Ismail"
                    3 -> "Bab El-Mansour"
                    else -> "Porte de Bab el-Mansour"
                }
            }) {
                Text(text = stringResource(R.string.roll))
            }
        }
    }
}

@Composable
fun Greeting(description: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Meknes",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )

        // Display the description below the name
        Text(
            text = description,
            fontSize = 14.sp,
            color = Color.White,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun ContactInfo() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ContactRow(icon = Icons.Filled.Phone, contactDetail = "el-Hedim in the old city")
        ContactRow(icon = Icons.Filled.Email, contactDetail = "mek.nes@android.com")
        ContactRow(icon = Icons.Filled.Person, contactDetail = "@Meknes_soloRedMan")
    }
}

@Composable
fun ContactRow(icon: ImageVector, contactDetail: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = contactDetail, fontSize = 18.sp, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardScreen()
    }
}
