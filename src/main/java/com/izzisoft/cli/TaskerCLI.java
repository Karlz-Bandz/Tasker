package com.izzisoft.cli;

import com.izzisoft.model.Task;
import com.izzisoft.service.TaskService;
import com.izzisoft.service.impl.TaskServiceImpl;

import java.util.List;
import java.util.Scanner;

public class TaskerCLI {

    private final Scanner scanner;
    private final TaskService taskService;

    public TaskerCLI() {
        this.scanner = new Scanner(System.in);
        this.taskService = new TaskServiceImpl();
    }

    public void start() {
        boolean gamePlay = true;

        System.out.println("=======================");
        System.out.println("======T-A-S-K-E-R======");
        System.out.println("=======================");

        while (gamePlay) {
            printMenu();

            String menuOption = scanner.nextLine();

            switch (menuOption) {
                case "1":
                    addTask();
                    break;
                case "2":
                    finishTask();
                    break;
                case "3":
                    deleteTask();
                    break;
                case "4":
                    showAllTasks();
                    break;
                case "5":
                    gamePlay = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("Option not known try again!");
                    System.out.println();
                    break;
            }
        }
    }

    private void showAllTasks() {
        int index = 0;
        List<Task> allTasks = taskService.getAllTasks();

        for (Task t : allTasks) {
            System.out.println("=======================");
            System.out.println(index + ". " + t.getDescription());
            System.out.println("Finished: " + t.isFinished());
            System.out.println("=======================");

            index++;
        }
    }

    private void deleteTask() {
        taskService.deleteLastTask();

        System.out.println("=======================");
        System.out.println("%$^&*^$@#$%^&*((*&^%$#@");
        System.out.println("The last task =========");
        System.out.println("deleted ===============");
        System.out.println("%$^&*^$@#$%^&*((*&^%$#@");
    }

    private void finishTask() {
        showAllTasks();

        System.out.println("=======================");
        System.out.println("Please provide the ====");
        System.out.println("task index... =========");
        System.out.println("=======================");

        int taskIndex = scanner.nextInt();
        taskService.finishTaskByIndex(taskIndex);

        System.out.println("=======================");
        System.out.println("%$^&*^$@#$%^&*((*&^%$#@");
        System.out.println("Task has been =========");
        System.out.println("finished ==============");
        System.out.println("%$^&*^$@#$%^&*((*&^%$#@");
    }

    private void addTask() {
        System.out.println("=======================");
        System.out.println("Please provide the ====");
        System.out.println("task description... ===");
        System.out.println("=======================");

        String taskDescription = scanner.nextLine();
        taskService.addNewTask(taskDescription);

        System.out.println("=======================");
        System.out.println("The task has been =====");
        System.out.println("added with success ====");
        System.out.println("=======================");
    }

    private void printMenu() {
        System.out.println("=======================");
        System.out.println("Chose an option =======");
        System.out.println("=======================");
        System.out.println("1. Add new task =======");
        System.out.println("2. Finish task ========");
        System.out.println("3. Del last task ======");
        System.out.println("4. Show all ===========");
        System.out.println("5. Exit ===============");
    }
}
