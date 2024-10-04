package com.afrikalabs.motionjet

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun VisibilityAnimation(modifier: Modifier=Modifier) {
    var visible by remember { mutableStateOf(true) }

    Button(onClick = { visible = !visible }) {
        Text("Toggle Visibility")
    }

    AnimatedVisibility(visible = visible) {
        Box(
            modifier = modifier
                .size(100.dp)
                .background(Color.Green)
        )
    }
}
