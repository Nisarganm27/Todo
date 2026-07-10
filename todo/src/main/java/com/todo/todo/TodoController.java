package com.todo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    // Display Home Page
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "index";
    }

    // Add Task
    @PostMapping("/add")
    public String addTask(@RequestParam("task") String task) {
        todoService.addTask(task);
        return "redirect:/";
    }

    // Delete Task
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        todoService.deleteTask(id);
        return "redirect:/";
    }

    // Mark Task as Completed
    @GetMapping("/complete/{id}")
    public String completeTask(@PathVariable int id) {
        todoService.markComplete(id);
        return "redirect:/";
    }

    // Mark Task as Pending
    @GetMapping("/pending/{id}")
    public String pendingTask(@PathVariable int id) {
        todoService.markPending(id);
        return "redirect:/";
    }

    // Open Edit Page
    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable int id, Model model) {
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo", todo);
        return "edit";
    }

    // Update Task
    @PostMapping("/update")
    public String updateTask(@RequestParam int id,
                             @RequestParam String task) {
        todoService.updateTask(id, task);
        return "redirect:/";
    }
}