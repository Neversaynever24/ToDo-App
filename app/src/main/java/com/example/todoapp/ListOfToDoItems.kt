package com.example.todoapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.ui.theme.ToDoAppTheme

@Composable
fun ListOfToDoItems(
    modifier: Modifier = Modifier
) {
    Surface (
        modifier = modifier,
        shape = MaterialTheme.shapes.medium
    ){
        LazyColumn(
            ) {
                items(TodoItemsRepository().getTodoItems()) { item ->
                    ToDoItemUI(item = item)
                }
            }
    }
}

@Preview (showBackground = true, backgroundColor = 0xFFF7F6F2)
@Composable
fun ListOfTodoItemsPreview () {
    ToDoAppTheme() {
        ListOfToDoItems(modifier = Modifier.padding(10.dp))
    }
}