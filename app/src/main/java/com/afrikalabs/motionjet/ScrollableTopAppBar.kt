package com.afrikalabs.motionjet

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrollableTopAppBar(modifier: Modifier=Modifier) {
    val scrollState = rememberLazyListState()
    val appBarHeight by animateDpAsState(
        targetValue = if (scrollState.firstVisibleItemScrollOffset > 0) 56.dp else 100.dp,
        label = ""
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Scroll Animation") },
                modifier = Modifier.height(appBarHeight)
            )
        }
    ) {
        LazyColumn(
            state = scrollState,
            contentPadding = it,
            modifier = Modifier.fillMaxSize()
        ) {
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
