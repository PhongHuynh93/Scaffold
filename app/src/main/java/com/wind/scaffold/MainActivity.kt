@file:OptIn(ExperimentalMaterialApi::class)

package com.wind.scaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        Box(
            Modifier.padding(innerPadding)
        ) {
            BasicChip()
        }
    }
}

@Composable
fun BasicChip() {
    Chip(onClick = {}, content = { Text("Basic Chip") })
}

@Composable
fun ClickableChip() {
    var isSelected by remember { mutableStateOf(false) }
    val backgroundColor = if (isSelected) Color.Blue else Color.Gray

    Chip(
        onClick = { isSelected = !isSelected },
        colors = ChipDefaults.chipColors(
            backgroundColor = backgroundColor,
            contentColor = Color.White
        )
    ) {
        Text("Clickable Chip")
    }
}

@Composable
fun RoundedChip() {
    Chip(
        onClick = {},
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ChipDefaults.chipColors(
            backgroundColor = Color.Gray,
            contentColor = Color.White
        )
    ) {
        Text("Rounded Chip")
    }
}

@Composable
fun OutlinedChip() {
    Chip(
        onClick = {},
        modifier = Modifier.padding(8.dp),
        shape = MaterialTheme.shapes.small,
        border = BorderStroke(1.dp, Color.Gray),
        colors = ChipDefaults.chipColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.Gray
        )
    ) {
        Text("Outlined Chip")
    }
}

@Composable
fun IconChip() {
    Chip(
        onClick = {},
        modifier = Modifier.padding(8.dp),
        colors = ChipDefaults.chipColors(
            backgroundColor = Color.Green,
            contentColor = Color.White
        ),
        leadingIcon = {
            Icon(Icons.Filled.Check, contentDescription = null, tint = Color.White)
        }
    ) {
        Text("Icon Chip")
    }
}

@Composable
fun CustomChip() {
    val colors = ChipDefaults.chipColors(
        backgroundColor = Color.Red,
        contentColor = Color.White,
        disabledContentColor = Color.Gray
    )

    Chip(
        onClick = { /* Do something */ },
        modifier = Modifier.padding(8.dp),
        enabled = false,
        interactionSource = remember { MutableInteractionSource() },
        shape = CutCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.Black),
        colors = colors,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color.Yellow
            )
        }
    ) {
        Text(
            text = "Custom Chip",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BasicChipPreview() {
    ScaffoldTheme {
        BasicChip()
    }
}

@Preview(showBackground = true)
@Composable
fun ClickableChipPreview() {
    ScaffoldTheme {
        ClickableChip()
    }
}

@Preview(showBackground = true)
@Composable
fun RoundedChipPreview() {
    ScaffoldTheme {
        RoundedChip()
    }
}

@Preview(showBackground = true)
@Composable
fun OutlinedChipPreview() {
    ScaffoldTheme {
        OutlinedChip()
    }
}

@Preview(showBackground = true)
@Composable
fun IconChipPreview() {
    ScaffoldTheme {
        IconChip()
    }
}

@Preview(showBackground = true)
@Composable
fun CustomChipPreview() {
    ScaffoldTheme {
        CustomChip()
    }
}
