package ch16access.example.ex1;

/* 최댓값 지정 후 최대값까지만 값이 증가하는 기능 제공하는 클래스 만들기
 * */
public class MaxCounter {

    int maxCount;
    int count;

    public MaxCounter(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public int getCount() {
        return count;
    }

    public void increase() {
        if (!isIncreaseAllowed(1)) {
            System.out.println("증가 불가 [최댓값 초과]");
            return;
        }
        count++;
    }

    public void increase(int amount) {
        if (!isIncreaseAllowed(amount)) {
            System.out.println("증가 불가 [최댓값 초과]");
            return;
        }
        count += amount;
    }

    private boolean isIncreaseAllowed(int amount) {
        return (count + amount) <= maxCount;
    }
}
