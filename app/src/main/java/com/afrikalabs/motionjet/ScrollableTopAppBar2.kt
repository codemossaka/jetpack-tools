package com.afrikalabs.motionjet

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrollableTopAppBar2() {
    val scrollState = rememberLazyListState()

    // Déterminer la hauteur de la TopAppBar en fonction du défilement
    val appBarHeight by animateDpAsState(
        targetValue = if (scrollState.firstVisibleItemScrollOffset > 0) 56.dp else 150.dp
    )

    // Scaffold avec TopAppBar animée
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Motion on Scroll", color = Color.White) },
                modifier = Modifier
                    .height(appBarHeight)
                    .background(MaterialTheme.colorScheme.primary),
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
//                backgroundColor = MaterialTheme.colorScheme.primary
            )
        }
    ) { innerPadding ->
        LazyColumn(
            state = scrollState,
            contentPadding = innerPadding,
            modifier = Modifier.fillMaxSize()
        ) {
            items(30) { index ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(100.dp)
                        .background(Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Item $index")
                }
            }
        }
    }
}
