package com.example.todoapp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;

public class TaskStorage {
    private static final TaskStorage taskStorage = new TaskStorage();
    @Getter private final List<Task> tasks;

    public Task getTask(UUID id) {
        for (Task task:tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }

    public static TaskStorage getInstance(){
        return taskStorage;
    }

    private TaskStorage() {
        tasks = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Task task = new Task();
            task.setName("Zadanie #" + i);
            task.setDone(i % 3 == 0);
            tasks.add(task);
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
