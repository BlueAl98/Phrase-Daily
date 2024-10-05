package com.bluecode.PhraseDaily.presentation.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.bluecode.PhraseDaily.presentation.homeScreen.HomeScreen
import com.bluecode.PhraseDaily.presentation.phrasalScreen.PhrsalVerbsScreen
import com.bluecode.PhraseDaily.presentation.verbsScreen.VerbsScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun MainScreen(modifier: Modifier = Modifier) {
    var selectedItem by remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomNavigationSample(
                selectedItem = selectedItem,
                onItemSelected = { selectedItem = it })
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Phrase Daily")
                },
                colors = TopAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White,
                    scrolledContainerColor = Color.Red
                ),
                modifier = modifier.padding(WindowInsets.statusBars.asPaddingValues())
            )
        }
    ) { innerPadding ->

        Column(modifier = modifier.padding(innerPadding)) {
            // Display the selected screen here based on the selected item
            when (selectedItem) {
                0 -> HomeScreen()
                1 -> PhrsalVerbsScreen()
                2 -> VerbsScreen()
            }
        }
    }

}

@Composable
fun BottomNavigationSample(selectedItem: Int, onItemSelected: (Int) -> Unit) {

    val items = listOf("Home", "Phrsal Verbs", "Verbs")
    val icons = List(3) { index ->
        when (index) {
            0 -> Icons.Filled.Home
            1 -> Icons.Filled.Book
            else -> Icons.Filled.Checklist
        }
    }


    NavigationBar(
        containerColor = Color.Blue,
        modifier = Modifier.background(Color.White)
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { icons.getOrNull(index)?.let { Icon(it, contentDescription = null) } },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { onItemSelected(index) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Blue,
                    selectedTextColor = Color.White,
                    indicatorColor = Color.White,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray

                )
            )
        }
    }
}

