package com.afrikalabs.motionjet

import androidx.compose.animation.Crossfade
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun CrossfadeExample(modifier: Modifier=Modifier) {
    var currentPage by remember { mutableStateOf("Page1") }

    Button(onClick = { currentPage = if (currentPage == "Page1") "Page2" else "Page1" }) {
        Text("Toggle Page")
    }

    Crossfade(modifier=modifier, targetState = currentPage, label = "") { screen ->
        when (screen) {
            "Page1" -> Text("This is Page 1")
            "Page2" -> Text("This is Page 2")
        }
    }
}
