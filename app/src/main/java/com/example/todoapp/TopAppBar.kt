package com.example.todoapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.ui.theme.ToDoAppTheme

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier
) {
    Surface (
        modifier = modifier
            .fillMaxWidth()
            .height(116.dp),
        color = MaterialTheme.colorScheme.primary
    )
     {
        Column () {
            Text(
                text = "Мои задания",
                fontSize = 32.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(
                        start = 60.dp,
                        top = 50.dp,
                        bottom = 4.dp
                    )
            )
            Text(
                text = "Выполнено - ${TodoItemsRepository().getTodoItems().filter{ it.isCompleted }.size}",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier
                    .padding(
                        start = 60.dp,
                        bottom = 2.dp
                    )
            )
        }

    }
}

@Preview (showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun TopAppBarPreview() {
    ToDoAppTheme {
        TopAppBar(Modifier.padding(10.dp))
    }
}