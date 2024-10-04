package com.afrikalabs.motionjet

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithSearchMotion3() {
    var isSearchActive by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }

    Scaffold(
        // Modifier pour conditionner l'affichage de la TopAppBar
        topBar = {
            if (!isSearchActive) {
                TopAppBar(
                    title = { Text("Search Example") },
                    actions = {
                        IconButton(onClick = { isSearchActive = !isSearchActive }) {
                            Icon(Icons.Default.Search, contentDescription = "Search")
                        }
                    }
                )
            }
        }
    ) { paddingValues ->

        // Content
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            // SearchBar visibility with full screen expansion
            AnimatedVisibility(
                visible = isSearchActive,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                SearchBarUI3(
                    searchText = searchText,
                    onSearchTextChanged = { searchText = it },
                    onClose = { isSearchActive = false }
                )
            }

            // Main content that is shown when search bar is not active
            if (!isSearchActive) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(50) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .height(100.dp)
                                .background(Color.LightGray),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Item $it", fontSize = 20.sp)
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarUI3(
    searchText: String,
    onSearchTextChanged: (String) -> Unit,
    onClose: () -> Unit
) {
    // Fullscreen search bar that appears when search is active
    SearchBar(
        query = searchText,
        onQueryChange = onSearchTextChanged,
        onSearch = { /* Execute search */ },
        active = true,
        onActiveChange = { /* No-op */ },
        placeholder = { Text("Search...") },
        modifier = Modifier.fillMaxSize(), // Occupy the full screen
        leadingIcon = {
            IconButton(onClick = onClose) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Close Search")
            }
        },
        trailingIcon = {
            if (searchText.isNotEmpty()) {
                IconButton(onClick = { onSearchTextChanged("") }) {
                    Icon(Icons.Default.Clear, contentDescription = "Clear Search")
                }
            }
        }
    ) {
        // Optional content when the search bar is expanded, like recent searches
        Text("Recent Searches", modifier = Modifier.padding(16.dp))
    }
}
