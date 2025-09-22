package day13;

public class MultiThreadExample {
    public static void main(String[] args) {

        Runnable task = () -> System.out.println(Thread.currentThread().getName() + " Hello Thread");

        Thread thread1 = new Thread(task, "스레드1");
        Thread thread2 = new Thread(task,"스레드2");

        thread1.start();
        thread2.start();
    }
}
