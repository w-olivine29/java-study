package ch21lang.section6math;

import java.util.Random;

// Random은 util에 속하지만 흐름상 math와 같이 넣었음
public class RandomMain {
    public static void main(String[] args) {
        Random random = new Random();

        int randomInt = random.nextInt();
        System.out.println("randomInt = " + randomInt);

        double randomDouble = random.nextDouble(); //0.0d ~ 1.0d
        System.out.println("randomDouble = " + randomDouble);

        boolean randomBoolean = random.nextBoolean();
        System.out.println("randomBoolean = " + randomBoolean);

        // 범위 조회
        System.out.println("random.nextInt(10) -> " + random.nextInt(10));  //0~9


        // 1부터 특정 숫자의 범위를 구하는 경우
        int result1 = random.nextInt(6) + 1; //1~6
        System.out.println("roll the dice -> " + result1);

        // java 17+ (시작점도 넣을 수 있게 됨)
        int result2 = random.nextInt(1, 7);  //1~6
        System.out.println("roll the dice -> " + result2);


        // Seed값 지정
        Random seed1 = new Random(1);
        int intNum = seed1.nextInt();
        System.out.println(intNum);

        System.out.println(seed1.nextDouble());
        System.out.println(seed1.nextBoolean());

        /*
         Random은 Seed 값을 기반으로 난수를 생성함.
         기본 생성자를 사용할 경우, 내부적으로 현재 시간을 기반으로 Seed가 자동 설정

         기본 생성자를 사용하면 실행할 때마다 다른 랜덤값을 생성하지만,
         Seed를 직접 지정하면 실행할 때마다 항상 같은 랜덤값을 얻을 수 있음.
         
         테스트, 디버깅 -> 반복 가능한 시뮬레이션
        */
    }
}
