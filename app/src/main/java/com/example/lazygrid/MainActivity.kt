package com.example.lazygrid

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazygrid.ui.theme.LazyGridTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun GridItem(label: String, imageResource: Int) {
    Box(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth() // Make each box take up the full width of the column
            .height(200.dp)
            .background(Color.LightGray)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally // Center both text elements horizontally
        ) {
            // Image on the left side
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp) // Adjust the image size as needed
            )

            Spacer(modifier = Modifier.height(4.dp)) // Add some spacing between image and text

            // Text on the right side
            Text(
                text = label,
                modifier = Modifier.padding(4.dp),
                style = TextStyle(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp)) // Add some spacing between text and additional text

            // Additional text below
            Text(
                text = "3 SKS",
                modifier = Modifier.padding(4.dp),
                style = TextStyle(fontSize = 12.sp),
                textAlign = TextAlign.Center
            )
        }
    }
}


@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val labels = listOf(
            "Dasar-Dasar Pemrograman", "Kewirausahaan", "Data Mining", "Animasi Komputer",
            "Struktur Data dan Algoritma",  "Pengantar Kecerdasan Buatan",
            "Mobile Computing", "STEM", "Komputer dan Masyarakat", "Teori Bahasa dan Automata"
        )

        setContent {
            LazyGridTheme {
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(10) { i ->
                        val label = labels[i % labels.size] // Get a unique label
                        val imageResource = when (i % 3) {
                            0 -> R.drawable.image1 // Replace with your image resource IDs
                            else -> R.drawable.image1
                        }

                        GridItem(label, imageResource)
                    }
                }
            }
        }
    }
}