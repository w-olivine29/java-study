package ch21lang.section3wrapper.sub2javawapper.step4performance;

public class WrapperVsPrimitive {
    public static void main(String[] args) {
        int iterations = 1_000_000_000;

        computePrimitive(iterations);  //226ms
        computeWrapper(iterations); //3269ms

        /*
        기본형은 메모리에서 단순히 그 크기만큼의 공간 차지 ex) int -> 4byte 메모리 사용
        래퍼 클래스의 경우 , 내부의 기본형 값 + 객체 자체를 다루는데 필요한 객체 메타데이터 포함 -> 더 많은 메모리 사용 (대략 8~16바이트 추가)

        하지만 특수한 상황이 아니라면, 코드의 유지보수성을 우선으로 고려
        최근에는 이런 부분을 최적화해도 성능에 큰 영향을 주지 않는 경우가 대부분 (위 예시는 10억 번 반복한 극단적인 경우)
        cpu 연산을 아주 많이 수행하는 경우이거나
        트래픽이 몰리는 상황에 성능 문제가 발생했을 때 최적화하는 것이 더 효과적
        
        유지보수 vs 최적화 부분 참고 (웹 어플리케이션 관련)
        */
    }

    // 기본형
    private static void computePrimitive(int iterations) {
        long startTime, endTime;

        long sumPrimitive = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            sumPrimitive += i;
        }
        endTime = System.currentTimeMillis();

        System.out.println("\nsumPrimitive: " + sumPrimitive);
        System.out.printf("기본 자료형 long 실행시간: %d ms\n", (endTime - startTime));
    }

    // 기본형
    private static void computeWrapper(int iterations) {
        long startTime, endTime;

        Long sumWrapper = 0L;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            sumWrapper += i; //오토 박싱
        }
        endTime = System.currentTimeMillis();

        System.out.println("\nsumWrapper: " + sumWrapper);
        System.out.printf("래퍼 클래스 Long 실행시간: %d ms\n", (endTime - startTime)); //226ms
    }
}
