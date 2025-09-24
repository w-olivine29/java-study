package ch04stream;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelTest {
    private final Faker faker = new Faker();

    /*
      - 동기화 문제: 병렬 스트림은 여러 스레드가 동시에 처리하기 때문에 동기화 문제가 발생 가능 (내부적으로 공용풀 사용)
      - 오버헤드: 스레드를 생성하고 관리하는 오버헤드가 발생
      - 순서 보장: 병렬 스트림은 순서를 보장 x
      - 디버깅 어려움: 병렬 스트림은 여러 스레드가 동시에 처리하기 때문에 디버깅이 어려운 편
     */
    @Test
    void sequentialVsParallel() {
        List<Integer> numbers = IntStream.range(0, 10).boxed().toList();

        long sequentialStartAt = System.currentTimeMillis();
        numbers.stream().forEach(
                i -> {
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        System.out.println("Sequential: " + (System.currentTimeMillis() - sequentialStartAt));

        long parallelStartAt = System.currentTimeMillis();
        numbers.parallelStream().forEach(
                i -> {
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        System.out.println("Parallel: " + (System.currentTimeMillis() - parallelStartAt));
    }
}
