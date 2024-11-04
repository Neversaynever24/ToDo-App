package com.example.todoapp

import java.time.LocalDate
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

    fun addTodoItem(item: TodoItem) {
        val newItem = item
        listOfTodoItem.add(newItem)
    }

    fun deleteTodoItem (id : String) {
        listOfTodoItem.removeAt(id.toInt())
    }
}