package com.example.todoapp

import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.ui.theme.ToDoAppTheme
import com.example.todoapp.ui.theme.LightToDoColors

@Composable
fun ToDoItemUI(
    modifier: Modifier = Modifier,
    item: TodoItem
) {
    var isChecked by rememberSaveable { mutableStateOf(item.isCompleted) }


    Surface  (
        modifier = modifier
            .fillMaxWidth(),
        color = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = !isChecked
                    item.isCompleted = isChecked
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    checkmarkColor = Color.White,
                    uncheckedColor = when {
                        item.isCompleted -> Color.Green
                        item.importance == Importance.HIGH -> Color.Red

                        else -> MaterialTheme.colorScheme.secondary
                    }
                )
            )
            Text(
                modifier = Modifier
                    .width(240.dp)
                    .padding(12.dp),
                text = item.text,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
                maxLines = 3
            )
            Icon(
                modifier = Modifier.padding(
                    end = 24.dp,
                    start = 16.dp,
                    top = 12.dp
                ),
                imageVector = Icons.Default.Info,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}

@Preview (showBackground = true, widthDp = 360)
@Composable
fun ToDoItemUIPreview () {
    ToDoAppTheme {
        ToDoItemUI(item = TodoItemsRepository().getTodoItems()[0])
    }
}