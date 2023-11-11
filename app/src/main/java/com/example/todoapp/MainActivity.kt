package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        var rvtodo = findViewById<RecyclerView>(R.id.rvTodoItems)
        rvtodo.adapter = todoAdapter
        rvtodo.layoutManager = LinearLayoutManager(this)

        var btnAdd = findViewById<Button>(R.id.btnaddTodo)
        var toTitle = findViewById<EditText>(R.id.etTodoTitle)
        var btnDelte = findViewById<Button>(R.id.btnDeleteTodo)
        btnAdd.setOnClickListener {
            val todoTitle = toTitle.text.toString()
            if(todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                toTitle.text.clear()
            }
        }
        btnDelte.setOnClickListener {
            todoAdapter.deleteDoneTodo()
        }
    }
}