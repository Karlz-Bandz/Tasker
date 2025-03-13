package com.izzisoft.cli;

import com.izzisoft.model.Task;
import com.izzisoft.service.TaskService;
import com.izzisoft.service.impl.TaskServiceImpl;

import java.util.ArrayList;
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
                    showAllFilteredTasks();
                    break;
                case "5":
                    taskService.clearAllTasks();
                    break;
                case "6":
                    gamePlay = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("Option not known try again!");
                    System.out.println();
                    break;
            }

            if (gamePlay) {
                System.out.println("Press enter...");
                scanner.nextLine();
            }
        }
    }

    private void showAllTasks() {
        List<Task> allTasks = taskService.getAllTasks();
        int indexValue = 0;

        for (Task t : allTasks) {
            System.out.println("=======================");
            System.out.println(indexValue + ". " + t.getDescription());
            System.out.println("Finished: " + t.isFinished());
            System.out.println("=======================");

            indexValue++;
        }
    }

    private void showAllFilteredTasks() {
        List<Task> tasks = new ArrayList<>();

        System.out.println("=======================");
        System.out.println("1. Finished tasks =====");
        System.out.println("2. Pending tasks ======");
        System.out.println("=======================");

        String taskPattern = scanner.nextLine();

        if (taskPattern.equals("1")) {
            tasks = taskService.getFinishedTasks();
            System.out.println("=======FINISHED========");
            System.out.println("Total: " + tasks.size());
            System.out.println("=======================");

        } else if (taskPattern.equals("2")) {
            tasks = taskService.getPendingTasks();
            System.out.println("=======PENDING=========");
            System.out.println("Total: " + tasks.size());
            System.out.println("=======================");
        } else {
            System.out.println("Wrong pattern!");
        }

        for (Task t : tasks) {
            System.out.println("Description:" + t.getDescription());
            System.out.println("Finished: " + t.isFinished());
            System.out.println("=======================");
        }
    }

    private void deleteTask() {
        boolean isDeleted = taskService.deleteLastTask();

        if (isDeleted) {
            System.out.println("=======================");
            System.out.println("%$^&*^$@#$%^&*((*&^%$#@");
            System.out.println("The last task =========");
            System.out.println("deleted ===============");
            System.out.println("%$^&*^$@#$%^&*((*&^%$#@");
        } else {
            System.out.println("%$^&*^$@#$%^&*((*&^%$#@");
            System.out.println("=======================");
            System.out.println("=======E-M-P-T-Y=======");
            System.out.println("=======================");
            System.out.println("%$^&*^$@#$%^&*((*&^%$#@");
        }
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
        scanner.nextLine();
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
        System.out.println("5. Clear all ==========");
        System.out.println("6. Exit ===============");
    }
}
