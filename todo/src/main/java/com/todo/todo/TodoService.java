package com.todo.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private List<Todo> todos = new ArrayList<>();
    private int id = 1;

    // View all tasks
    public List<Todo> getAllTodos() {
        return todos;
    }

    // Add a new task
    public void addTask(String task) {
        todos.add(new Todo(id++, task));
    }

    // Delete a task
    public void deleteTask(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    // Get a task by ID
    public Todo getTodoById(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    // Update/Edit a task
    public void updateTask(int id, String task) {
        Todo todo = getTodoById(id);
        if (todo != null) {
            todo.setTask(task);
        }
    }

    // Mark task as completed
    public void markComplete(int id) {
        Todo todo = getTodoById(id);
        if (todo != null) {
            todo.setCompleted(true);
        }
    }

    // Mark task as pending
    public void markPending(int id) {
        Todo todo = getTodoById(id);
        if (todo != null) {
            todo.setCompleted(false);
        }
    }
}