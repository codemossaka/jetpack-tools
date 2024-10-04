package com.afrikalabs.motionjet

import androidx.compose.animation.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun EnterExitAnimation(modifier: Modifier=Modifier) {
    var visible by remember { mutableStateOf(true) }

    Column(modifier = modifier) {
        Button(onClick = { visible = !visible }) {
            Text("Toggle Animation")
        }

        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically(initialOffsetY = { -1000 }) + fadeIn(),
            exit = slideOutVertically(targetOffsetY = { 1000 }) + fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Magenta)
            )
        }
    }
}
