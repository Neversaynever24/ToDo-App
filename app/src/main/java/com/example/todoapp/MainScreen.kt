package com.example.todoapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.ui.theme.ToDoAppTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
   Scaffold(
       modifier = modifier,
       containerColor = MaterialTheme.colorScheme.primary,
       topBar = {
           TopAppBar()
       },
       floatingActionButton = {
           IconButton(
               modifier = Modifier
                   .size(56.dp)
                   .clip(CircleShape),
               onClick = {},
               colors = IconButtonDefaults.iconButtonColors(
                   containerColor = Color(0xFF007AFF)
               ),
           ) {
                Icon (
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.White
                )
           }
       },
       content = { paddingValues ->
           Box (
               modifier = Modifier.padding(paddingValues)
           ) {
               ListOfToDoItems(modifier = Modifier.padding(
                   start = 8.dp,
                   end = 8.dp,
                   top = 16.dp
               )
               )
           }
       }
   )
}

@Preview
@Composable
fun MainScreenPreview() {
    ToDoAppTheme {
        MainScreen()
    }
}