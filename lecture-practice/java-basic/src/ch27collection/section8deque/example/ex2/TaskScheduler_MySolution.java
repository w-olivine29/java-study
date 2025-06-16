package ch27collection.section8deque.example.ex2;

import java.util.Objects;
import java.util.Queue;

public class TaskScheduler_MySolution {

    private final Queue<Task> taskQueue;

    public TaskScheduler_MySolution(Queue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void addTask(Task task) {
        taskQueue.offer(task);
    }

    public int getRemainingTaskCount() {
        return taskQueue.size();
    }


    public void processNextTask() {
        Objects.requireNonNull(taskQueue.poll()).execute();
    }
}
