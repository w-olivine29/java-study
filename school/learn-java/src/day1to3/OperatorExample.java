package day1to3;

public class OperatorExample {
    public static void main(String[] args) {
        // 1. 산술 연산자
        int a = 10 + 5;  // 15
        int b = 10 - 5;  // 5
        int c = 10 * 5;  // 50
        int d = 10 / 5;  // 2
        int e = 10 % 3;  // 1 (나머지)

        // 2. 대입 연산자
        int number = 10;        // 10을 number에 저장
        String name = "zero";  // "zero"을 name에 저장

        // 3. 증감 연산자 (예시 코드는 후위연산자)
        int count = 1;
        count++;  // count = count + 1
        count--;  // count = count - 1

        // 4. 비교 연산자
        int x = 10;
        int y = 20;
        boolean aa = x > y;
        boolean bb = x < y;
        boolean cc = x == y;

        // 5. 논리 연산자
        boolean isRaining = true;
        boolean isCold = true;
        boolean result1 = isRaining && isCold;  // 비가 오고 춥다 (true)

//  활용 =========================================================================================
        // 1. 합격/불합격 판단
        int score = 85;
        String result2 = score >= 60 ? "합격" : "불합격";
        System.out.println("합격 유무 = " + result2); // 합격

        // 2. 양수/음수 판단
        int num1 = -5;
        String type = num1 > 0 ? "positive " : "negative ";
        System.out.println("양수/음수 = " + type); // 음수

        // 3. 홀수/짝수 판단
        int num2 = 6;
        String evenOdd = num2 % 2 == 0 ? "even" : "odd";
        System.out.println("홀수/짝수 = " + evenOdd); // 짝수

        // 4. 더 큰 수 찾기
        int aaa = 10, bbb = 20;
        int bigger = aaa > bbb ? aaa : bbb;
        System.out.println("더 큰 수  = " + bigger); // 20

        // 5. 할인 적용
        int price = 10000;
        boolean isMember = true;
        int finalPrice = isMember ? price - 1000 : price;
        System.out.println("회원 할인 가격 = " + finalPrice); // 9000


//  =========================================================================================
        // 1. 문자열끼리 합치기
        String greeting = "안녕하세요" + " 반갑습니다"; // "안녕하세요 반갑습니다"
        System.out.println("greeting = " + greeting);

        // 2. 문자열 & 숫자 합치기
        String introduce = "제 나이는 " + 100 + "살 입니다"; // "제 나이는 100살 입니다"
        System.out.println("introduce = " + introduce);

        // 3. 문자열 & 정수 변수 합치기
        int age = 100;
        System.out.println("제 나이는 " + age + "살 입니다."); // 제 나이는 100살 입니다.


        // 4. 문자열 + 숫자 계산
        int amount = 1000;
        int cnt= 3;
        System.out.println("총 가격: " + amount * cnt + "원"); // 총 가격: 3000원

        // 4. 주의사항 ==============================
        // 숫자 + 숫자 + 문자열 (동작방식 : 먼저 1 + 2 = 3 계산 후 "번"과 합쳐짐)
        System.out.println(1 + 2 + "번"); //3번


        // 문자열 + 숫자 + 숫자 (동작방식 : "번호"와 1을 먼저 합친 후 2를 합침)
        System.out.println("번호" + 1 + 2); //번호12


        // 괄호 사용 (괄호가 우선 순위가 더 높음)
        System.out.println("결과: " + (1 + 2));  // 결과: 3
        System.out.println("결과: " + 1 + 2);    // 결과: 12



        // 예제) 10000원으로 3500원짜리 물건을 샀을 때 거스름돈을 계산해서 출력해보기

        int money = 10000;
        int price2 = 3500;

        int change = money - price2;
        System.out.println("거스름돈: " + change + "원"); //거스름돈: 6500원
    }
}
