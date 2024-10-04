package com.afrikalabs.motionjet

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.runtime.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

enum class BoxState { Small, Large }

@Composable
fun TransitionBox(modifier: Modifier=Modifier) {
    var boxState by remember { mutableStateOf(BoxState.Small) }

    val transition = updateTransition(targetState = boxState, label = "Box Transition")

    val size by transition.animateDp(label = "Size") { state ->
        if (state == BoxState.Small) 100.dp else 200.dp
    }
    val alpha by transition.animateFloat(label = "Alpha") { state ->
        if (state == BoxState.Small) 1f else 0.5f
    }

    Box(
        modifier = modifier
            .size(size)
            .background(Color.Red.copy(alpha = alpha))
            .clickable {
                boxState = if (boxState == BoxState.Small) BoxState.Large else BoxState.Small
            }
    )
}
