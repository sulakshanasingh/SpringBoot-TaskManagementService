package com.example.task.controller;

import com.example.task.model.Task;
import com.example.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;
    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Task addTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @GetMapping(produces = "application/json")
    public List<Task> findAllTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    public Task findTaskById(@PathVariable int id) {
        return taskService.getTaskById(id);
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task) {
        return taskService.update(task);
    }
}
