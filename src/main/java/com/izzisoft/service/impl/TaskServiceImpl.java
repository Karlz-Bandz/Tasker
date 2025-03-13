package com.izzisoft.service.impl;

import com.izzisoft.repo.TaskRepo;
import com.izzisoft.model.Task;
import com.izzisoft.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;

    public TaskServiceImpl() {
        this.taskRepo = TaskRepo.getTaskRepoInstance();
    }

    @Override
    public void addNewTask(String taskDescription) {
        Task task = new Task();
        task.setDescription(taskDescription);
        task.setFinished(false);
        taskRepo.addTask(task);
    }

    @Override
    public void deleteLastTask() {
        taskRepo.getAllTasks().removeLast();
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepo.getAllTasks();
    }

    @Override
    public void changeTaskDescriptionByIndex(int index, String newTaskDescription) {
        Task task = taskRepo.getTaskByIndex(index);
        task.setDescription(newTaskDescription);
    }

    @Override
    public void finishTaskByIndex(int index) {
        Task task = taskRepo.getTaskByIndex(index);
        task.setFinished(true);
    }
}
