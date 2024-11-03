package com.example.todoapp

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

class TodoItemsRepository {
    private val listOfTodoItem = mutableListOf(
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
        TodoItem("0","Купить дом", Importance.SIMPLE, null,true, localDateToDate(LocalDate.of(2003, 3, 12)), null),
    )

    private fun localDateToDate(localDate: LocalDate): Date {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant())
    }

    public fun getTodoItem () : MutableList<TodoItem> {
        return this.listOfTodoItem
    }

    fun addTodoItem(id: String, title: String, importance: Importance, deadline: Date?, isCompleted: Boolean, createdAt: Date, modifiedAt: Date?) {
        val newItem = TodoItem(id, title, importance, deadline, isCompleted, createdAt, modifiedAt)
        listOfTodoItem.add(newItem)
    }

    fun deleteTodoItem (id : String) {
        listOfTodoItem.removeAt(id.toInt())
    }
}