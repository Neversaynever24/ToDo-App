package com.example.todoapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.ui.theme.ToDoAppTheme

@Composable
fun EditTodoItemScreen(
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier
        .fillMaxSize()) {
        Column {
            Row(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "close",
                        tint = Color.Black
                    )
                }
                TextButton(
                    onClick = {}
                ) {
                    Text(
                        text = "СОХРАНИТЬ",
                        color = Color(0xFF007AFF),
                        fontSize = 14.sp
                    )
                }
            }
            TextFieldTodo(modifier = Modifier.padding(horizontal = 8.dp))
            
        }
    }
}

@Preview (showBackground = true)
@Composable
fun EditTodoItemScreenPreview() {
    ToDoAppTheme {
        EditTodoItemScreen()
    }
}

@Composable
fun TextFieldTodo(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }

    TextField(
        modifier = modifier
            .fillMaxWidth(),
        onValueChange = { newText ->
            text = newText
        },
        placeholder = {Text("Что надо сделать...", color = MaterialTheme.colorScheme.tertiary)},
        value = text,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White
        ),
        minLines = 5
    )
}

