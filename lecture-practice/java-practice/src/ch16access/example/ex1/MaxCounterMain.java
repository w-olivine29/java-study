package ch16access.example.ex1;

public class MaxCounterMain {
    public static void main(String[] args) {
        MaxCounter maxCounter = new MaxCounter(5);
        System.out.println("설정된 최대값: " + maxCounter.getMaxCount());

        maxCounter.increase();
        System.out.println("현재 카운트: " + maxCounter.getCount());

        maxCounter.increase(2);
        System.out.println("현재 카운트: " + maxCounter.getCount());

        maxCounter.increase(2);
        System.out.println("현재 카운트: " + maxCounter.getCount());

        maxCounter.increase(1);
        System.out.println("현재 카운트: " + maxCounter.getCount());
    }

}
