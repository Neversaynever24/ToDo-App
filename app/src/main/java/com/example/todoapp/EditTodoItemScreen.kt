package com.example.todoapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.ui.theme.ToDoAppTheme
import java.time.LocalDate
import java.util.Date

@Composable
fun EditTodoItemScreen(
    modifier: Modifier = Modifier
) {
    val idOfNewItem = TodoItemsRepository().getTodoItems().size + 1
    var newTodoItem by remember {   mutableStateOf(TodoItem(
        idOfNewItem.toString(),
        "",
        Importance.LOW,
        deadline = null,
        isCompleted = false,
        createdAt = Date(),
        modifiedAt = null
        ))}

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier
        .fillMaxSize()
    ) {
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
                    onClick = {
                        TodoItemsRepository().addTodoItem(newTodoItem)
                    }
                ) {
                    Text(
                        text = "СОХРАНИТЬ",
                        color = Color(0xFF007AFF),
                        fontSize = 14.sp
                    )
                }
            }
            TextFieldTodo(modifier = Modifier.padding(horizontal = 8.dp), newTodoItem)
            ImportanceList(newTodoItem = newTodoItem)
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
fun TextFieldTodo(modifier: Modifier = Modifier, newTodoItem: TodoItem) {
    var text by remember { mutableStateOf("") }

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .onFocusChanged {  },
        onValueChange = { newText ->
            text = newText
            newTodoItem.text = newText
        },
        placeholder = {Text("Что надо сделать...", color = MaterialTheme.colorScheme.tertiary)},
        value = text,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White
        ),
        minLines = 5
    )
}

@Composable
fun ImportanceList(modifier: Modifier = Modifier, newTodoItem: TodoItem) {
    var expanded by remember { mutableStateOf(false) }
    var selectedImportance by remember { mutableStateOf("нет") }

    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        TextButton(
            onClick = {expanded = true}
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Важность", fontSize = 16.sp, color = Color.Black)
                Text(text = selectedImportance, fontSize = 14.sp,
                    color = if (selectedImportance == "Высокий") Color.Red else MaterialTheme.colorScheme.tertiary
                )
            }
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(color = Color.White),
            offset = DpOffset(x = 20.dp, y = 10.dp)
        ) {
            DropdownMenuItem(
                text = { Text("Нет") },
                onClick = {
                    selectedImportance = "нет"
                    newTodoItem.importance = Importance.LOW
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = { Text("Низкий") },
                onClick = {
                    selectedImportance = "Низкий"
                    expanded = false
                    newTodoItem.importance = Importance.SIMPLE
                }
            )
            DropdownMenuItem(
                text = { Text("Высокий", color = Color.Red) },
                onClick = {
                    selectedImportance = "Высокий"
                    newTodoItem.importance = Importance.HIGH
                    expanded = false
                }
            )
        }
    }
}
