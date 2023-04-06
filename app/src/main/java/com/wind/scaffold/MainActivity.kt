package com.wind.scaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.primarySurface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wind.scaffold.ui.theme.ScaffoldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyScreen() {
    Scaffold(
        topBar = { // specify the app bar
            TopAppBar(
                title = { Text("My App") },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        },
        floatingActionButton = { // specify the FAB
            FloatingActionButton(onClick = { /* do something */ }) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
        }
    ) { innerPadding -> // specify the body content
        // create a scrolling list of items
        LazyColumn(
            Modifier.padding(innerPadding)
        ) {
            items(20) { index ->
                ListItem(text = {
                    Text("Item $index")
                })
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyPage() {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("My App") },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.primarySurface,
                contentColor = MaterialTheme.colors.onPrimary
            ) {
                BottomNavigationItem(
                    selected = true,
                    icon = { Icon(Icons.Filled.Home, contentDescription = null) },
                    label = { Text("Home") },
                    onClick = { /* do something */ }
                )
                BottomNavigationItem(
                    selected = false,
                    icon = { Icon(Icons.Filled.Settings, contentDescription = null) },
                    label = { Text("Settings") },
                    onClick = { /* do something */ }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* do something */ }
            ) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = true,
        drawerContent = {
            Column(
                Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Drawer Header",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(16.dp)
                )
                Divider()
                Text(
                    text = "Item 1",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(16.dp)
                )
                Text(
                    text = "Item 2",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(16.dp)
                )
            }
        },
        content = { innerPadding ->
            LazyColumn(
                Modifier.padding(innerPadding)
            ) {
                items(20) { index ->
                    ListItem(text = {
                        Text("Item $index")
                    })
                }
            }
        },
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.onSurface,
        snackbarHost = {
            SnackbarHost(it) { data ->
                Snackbar(
                    content = { Text(data.message) },
                    action = {
                        TextButton(onClick = { data.performAction() }) {
                            Text(data.actionLabel ?: "Dismiss")
                        }
                    }
                )
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun SimpleScaffoldPreview() {
    ScaffoldTheme {
        MyScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun AdvancedScaffoldPreview() {
    ScaffoldTheme {
        MyPage()
    }
}
