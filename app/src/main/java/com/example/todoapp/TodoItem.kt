package com.example.todoapp

import java.util.Date


enum class Importance {
    LOW,
    SIMPLE,
    HIGH
}

data class TodoItem(
    var id: String,
    var text: String,
    var importance: Importance,
    var deadline: Date?,
    var isCompleted: Boolean,
    var createdAt: Date,
    var modifiedAt: Date?
)
