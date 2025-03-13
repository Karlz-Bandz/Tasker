package com.izzisoft.service;

import com.izzisoft.model.Task;

import java.util.List;

public interface TaskService {
    void addNewTask(String taskDescription);

    void deleteLastTask();

    List<Task> getAllTasks();

    void changeTaskDescriptionByIndex(int index, String newTaskDescription);

    void finishTaskByIndex(int index);
}
