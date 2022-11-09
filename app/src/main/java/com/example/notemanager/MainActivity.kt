package com.example.notemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.notemanager.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteManagerTheme() {
                Surface(Modifier.background(Color.Gray)) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Square()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text("Hello $name")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoteManagerTheme {
        Greeting("Android")
    }
}

@Composable
fun Square(componentSize: Dp = 200.dp) {

    val canvasSizePx = with(LocalDensity.current) {
        componentSize.toPx()
    }
    val infiniteScale = rememberInfiniteTransition()
    val animatedDotScale by infiniteScale.animateFloat(
        initialValue = 20f,
        targetValue = canvasSizePx / 2,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    Canvas(
        modifier = Modifier.size(200.dp)
    ) {
        drawRect(
            brush = Brush.linearGradient(
                listOf(Purple200, Teal200)
            )
        )
        drawCircle(
            color = Color.White,
            center = Offset(
                x = size.width / 2f,
                y = size.height / 2f),
            radius = animatedDotScale
        )
    }
}