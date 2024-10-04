package com.afrikalabs.motionjet

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedSizeBox(modifier: Modifier=Modifier) {
    var isClicked by remember { mutableStateOf(false) }

    val size by animateDpAsState(
        targetValue = if (isClicked) 200.dp else 100.dp,
        animationSpec = tween(durationMillis = 500),
        label = "" // Animation avec une durée spécifique
    )

    Box(
        modifier = modifier
            .size(size)
            .background(Color.Blue)
            .clickable { isClicked = !isClicked }
    )
}
