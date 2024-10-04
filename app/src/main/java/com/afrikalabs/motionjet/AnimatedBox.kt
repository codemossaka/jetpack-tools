package com.afrikalabs.motionjet

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedBox(modifier: Modifier=Modifier) {
    var isClicked by remember { mutableStateOf(false) }

    val backgroundColor by animateColorAsState(
        targetValue = if (isClicked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary,
        label = ""
    )

    Box(
        modifier = modifier
            .size(100.dp)
            .background(backgroundColor)
            .clickable { isClicked = !isClicked }
    )
}
