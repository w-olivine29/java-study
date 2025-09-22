package day4;


// 문제 : 배열과 반복문으 활용한 간단한 로또 번호 생성기 만들어보기
public class Array {
    public static void main(String[] args) {


        // 1. 로또 번호를 저장할 배열 생성 (6개의 숫자)
        int[] lotto = new int[6];

        // 2. 로또 번호 생성 (1~45)
        for (int i = 0; i < 6; i++) {
            // 1~45 사이의 랜덤한 숫자 생성
            int num = (int) (Math.random() * 45) + 1;

            // 중복 검사
            boolean isDuplicated = false;

            // 이미 생성된 번호와 비교
            for (int j = 0; j < i; j++) {
                if (lotto[j] == num) {
                    isDuplicated = true;
                    i--; // 중복이면 이번 회차 다시
                    break;
                }
            }

            // 중복이 아닐 경우에만 배열에 저장
            if (!isDuplicated) {
                lotto[i] = num;
            }
        }

        // 생성된 로또 번호를 출력
        System.out.println("로또 번호: ");
        for (int i = 0; i< lotto.length; i++) {
            System.out.println(lotto[i] + " ");
        }
    }
}
