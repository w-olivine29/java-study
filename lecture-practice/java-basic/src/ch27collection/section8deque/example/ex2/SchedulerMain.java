package ch27collection.section8deque.example.ex2;

import java.util.ArrayDeque;

/* 작업 예약
 
 다음 코드를 참고하여 TaskSchedular 구현
*/
public class SchedulerMain {
    public static void main(String[] args) {
        //낮에 작업을 저장
        TaskScheduler_MySolution scheduler = new TaskScheduler_MySolution(new ArrayDeque<>());
        scheduler.addTask(new CompressionTask());
        scheduler.addTask(new BackupTask());
        scheduler.addTask(new CleanTask());

        //새벽 시간에 실행
        System.out.println("==작업 시작==");
        run(scheduler);
        System.out.println("==작업 완료==");
    }

    private static void run(TaskScheduler_MySolution scheduler) {
        while (scheduler.getRemainingTaskCount() > 0) {
            scheduler.processNextTask();
        }
    }
}