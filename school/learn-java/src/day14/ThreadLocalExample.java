package day14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalExample {
    public static void main(String[] args) {

        // ThreadLocal를 비우지 않고 스레드 재사용 시도
        Runnable task = () -> {
            System.out.printf("%s - before set value: %d\n",
                    Thread.currentThread().getName(), threadLocalValue.get());

            threadLocalValue.set((int) (Math.random() * 10));

            System.out.printf("%s - after set value: %d\n",
                    Thread.currentThread().getName(), threadLocalValue.get());

            //threadLocalValue.remove();
            System.out.println();
        };


        try(ExecutorService service = Executors.newFixedThreadPool(2)){
            for (int i = 0; i < 10; i++) {
                service.execute(task);
                Thread.sleep(1000); // 출력 메세지를 동일한 task 단위로 보기위함
            }
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);
}


/* ThreadLocal를 비우지 않고 스레드 재사용한 결과

pool-1-thread-1 - before set value: 0
pool-1-thread-1 - after set value: 3

pool-1-thread-2 - before set value: 0
pool-1-thread-2 - after set value: 7

pool-1-thread-1 - before set value: 3
pool-1-thread-1 - after set value: 9

pool-1-thread-2 - before set value: 7
pool-1-thread-2 - after set value: 1

pool-1-thread-1 - before set value: 9
pool-1-thread-1 - after set value: 2

pool-1-thread-2 - before set value: 1
pool-1-thread-2 - after set value: 4

pool-1-thread-1 - before set value: 2
pool-1-thread-1 - after set value: 5

pool-1-thread-2 - before set value: 4
pool-1-thread-2 - after set value: 1

pool-1-thread-1 - before set value: 5
pool-1-thread-1 - after set value: 5
*/
