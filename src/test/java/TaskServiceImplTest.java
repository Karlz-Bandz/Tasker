import com.izzisoft.model.Task;
import com.izzisoft.repo.TaskRepo;
import com.izzisoft.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskServiceImplTest {

    private final TaskServiceImpl taskService;
    private final TaskRepo taskRepo;

    public TaskServiceImplTest() {
        this.taskService = new TaskServiceImpl();
        this.taskRepo = TaskRepo.getTaskRepoInstance();
    }

    @BeforeEach
    void setMockRepo() {
        Task task1 = new Task();
        task1.setDescription("test1");
        task1.setFinished(false);

        Task task2 = new Task();
        task2.setDescription("test2");
        task2.setFinished(true);

        Task task3 = new Task();
        task3.setDescription("test2");
        task3.setFinished(false);

        taskRepo.clearTasks();
        taskRepo.addTask(task1);
        taskRepo.addTask(task2);
        taskRepo.addTask(task3);
    }

    @Test
    void addNewTaskTest() {
        taskService.addNewTask("test3");
        assertEquals(4, taskRepo.getAllTasks().size());
    }

    @Test
    void deleteLastTaskTest() {
        taskService.deleteLastTask();
        assertEquals(2, taskRepo.getAllTasks().size());
    }

    @Test
    void getPendingTasksTest() {
        List<Task> pendingTasks = taskService.getPendingTasks();
        assertEquals(2, pendingTasks.size());
    }

    @Test
    void getFinishedTasksTest() {
        List<Task> finishedTasks = taskService.getFinishedTasks();
        assertEquals(1, finishedTasks.size());
    }

    @Test
    void getAllTasksTest() {
        List<Task> finishedTasks = taskService.getAllTasks();
        assertEquals(3, finishedTasks.size());
    }

    @Test
    void clearAllTasksTest() {
        taskService.clearAllTasks();
        assertEquals(0, taskRepo.getAllTasks().size());
    }

    @Test
    void changeTaskDescriptionByIndexTest() {
        taskService.changeTaskDescriptionByIndex(1, "test666");
        Task task = taskRepo.getTaskByIndex(1);

        assertEquals("test666", task.getDescription());
    }

    @Test
    void finishTaskByIndexTest() {
        taskService.finishTaskByIndex(1);
        Task task = taskRepo.getTaskByIndex(1);

        assertTrue(task.isFinished());
    }
}
