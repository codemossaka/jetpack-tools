package com.afrikalabs.motionjet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.max

@Composable
fun ParallaxScroll(modifier: Modifier=Modifier) {
    val scrollState = rememberLazyListState()

    Box(modifier=modifier) {
        // Arrière-plan parallax
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .offset { IntOffset(x = 0, y = -scrollState.firstVisibleItemScrollOffset / 2) }
        )
        LazyColumn(state = scrollState) {
            items(50) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(100.dp)
                        .background(Color.LightGray)
                )
            }
        }
    }
}
