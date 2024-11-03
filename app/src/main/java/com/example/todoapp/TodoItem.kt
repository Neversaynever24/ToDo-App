package com.example.todoapp

import java.util.Date


enum class Importance {
    LOW,
    SIMPLE,
    HIGH
}

data class TodoItem(
    val id: String,
    val text: String,
    val importance: Importance,
    val deadline: Date?,
    val isCompleted: Boolean,
    val createdAt: Date,
    val modifiedAt: Date?
)
