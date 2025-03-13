package com.izzisoft.service;

import com.izzisoft.model.Task;

import java.util.List;

public interface TaskService {
    void addNewTask(String taskDescription);

    boolean deleteLastTask();

    List<Task> getAllTasks();

    List<Task> getFinishedTasks();

    List<Task> getPendingTasks();

    void clearAllTasks();

    void changeTaskDescriptionByIndex(int index, String newTaskDescription);

    void finishTaskByIndex(int index);
}
