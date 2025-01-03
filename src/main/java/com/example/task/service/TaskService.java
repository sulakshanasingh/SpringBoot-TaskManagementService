package com.example.task.service;

import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public Task saveTask(Task task) {
        return repository.save(task);
    }

    public List<Task> getTasks() {
        return repository.getAllTasks();
    }

    public Task getTaskById(int id) {
        return repository.findById(id);
    }

    public String delete(int id) {
        repository.delete(id);
        return "Task removed !! " + id;
    }

    public Task update(Task task) {
        return repository.update(task);
    }
}
