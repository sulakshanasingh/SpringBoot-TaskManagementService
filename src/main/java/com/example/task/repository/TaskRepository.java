package com.example.task.repository;

import com.example.task.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TaskRepository {

    private List<Task> list = new ArrayList<Task>();

    public void createTasks() {
        list = List.of(
                new Task(1, "Task 1", false),
                new Task(2, "Task 2", false),
                new Task(3, "Task 3", false),
                new Task(4, "Task 4", false),
                new Task(5, "Task 5", false),
                new Task(6, "Task 6", false)
        );
    }

    public List<Task> getAllTasks() {
        createTasks();
        return list;
    }

    public Task findById(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (id)) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<Task> search(String name) {
        return list.stream().filter(x -> x.getName().startsWith(name)).collect(Collectors.toList());
    }

    public Task save(Task p) {
        Task Task = new Task(p.getId(), p.getName(), p.isCompleted());
        list.add(Task);
        return Task;
    }

    public String delete(Integer id) {
        list.removeIf(x -> x.getId() == (id));
        return null;
    }

    public Task update(Task task) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (task.getId())) {
                id = task.getId();
                idx = i;
                break;
            }
        }

        Task Task1 = new Task(id,task.getName(),true);
        list.set(idx, task);
        return Task1;
    }
}
