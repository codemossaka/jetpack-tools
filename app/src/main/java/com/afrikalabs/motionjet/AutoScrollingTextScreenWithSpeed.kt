package com.afrikalabs.motionjet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoScrollingTextScreenWithSpeed() {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    var isScrolling by remember { mutableStateOf(false) }
    var selectedSpeed by remember { mutableStateOf(ScrollSpeed.Medium) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Auto Scroll Text with Speed") })
        },
        floatingActionButton = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                FloatingActionButton(
                    onClick = {
                        isScrolling = !isScrolling
                        if (isScrolling) {
                            // Start auto-scroll
                            coroutineScope.launch {
                                while (isScrolling) {
                                    val maxScroll = scrollState.maxValue
                                    val currentScroll = scrollState.value

                                    if (currentScroll < maxScroll) {
                                        scrollState.animateScrollTo(currentScroll + 50)
                                    } else {
                                        isScrolling = false // Stop scrolling if at the bottom
                                    }
                                    // Delay based on selected speed
                                    delay(selectedSpeed.delayInMillis)
                                }
                            }
                        }
                    }
                ) {
                    if (isScrolling) {
                        Text("Pause")
                    } else {
                        Text("Play")
                    }
                }

                // Speed selection buttons
                Row(
                    modifier = Modifier.padding(top = 16.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    ScrollSpeed.entries.forEach { speed ->
                        Button(
                            onClick = { selectedSpeed = speed },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (selectedSpeed == speed) Color.Blue else Color.Gray
                            ),
                            modifier = Modifier.padding(horizontal = 4.dp)
                        ) {
                            Text(text = speed.label)
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = generateLongText(),
                fontSize = 18.sp,
                textAlign = TextAlign.Justify
            )
        }
    }
}

// Define scroll speeds with labels and corresponding delays
enum class ScrollSpeed(val label: String, val delayInMillis: Long) {
    Slow("Slow", 100L),
    Medium("Medium", 50L),
    Fast("Fast", 20L)
}