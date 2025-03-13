package org.example.repo;

import org.example.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepo {

    private static TaskRepo taskRepoInstance;
    private final List<Task> tasks;

    private TaskRepo() {
        tasks = new ArrayList<>();
    }

    public static TaskRepo getTaskRepoInstance() {
        if (taskRepoInstance == null) {
            taskRepoInstance = new TaskRepo();
        }
        return taskRepoInstance;
    }

    public Task getTaskByIndex(int index) {
        return tasks.get(index);
    }

    public void clearTasks() {
        tasks.clear();
    }

    public void addTask(Task task) {
        tasks.addLast(task);
    }

    public List<Task> getAllTasks() {
        return tasks;
    }
}
