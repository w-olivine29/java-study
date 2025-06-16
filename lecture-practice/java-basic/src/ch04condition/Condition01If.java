package ch04condition;

public class Condition01If {
    public static void main(String[] args) {
        int age = 30;

        System.out.println("==== if ====================");
        if (age < 30) { // 진입x
            System.out.println("20대입니다!");
        }
        if (age >= 30) {
            System.out.println("30대입니다..");
        }


        System.out.println("==== else ====================");
        if (age < 19) {
            System.out.println("미성년자입니다");
        } else {
            System.out.println("성인입니다.");
        }


        System.out.println("==== else if ====================");

        /*
        하나의 if 문으로 묶는 느낌
        처음부터 끝까지 모든 조건에 진입하는 것이 아닌,
        순차적으로 조건에 진입하다가,
        true인 조건을 찾으면 해당 블럭으로 진입 후 실행 뒤 if문 전체를 탈출
        */
        if (age <= 7) {
            System.out.println("미취학 아동입니다.");
        } else if (age >= 8 && age <= 13) {
            System.out.println("초등학생입니다.");
        } else if (age >= 14 && age <= 16) {
            System.out.println("중학생입니다.");
        } else if (age >= 17 && age <= 19) {
            System.out.println("고등학생입니다.");
        } else if (age >= 20) {
            System.out.println("성인입니다.");
        }

        System.out.println("==== if & else if ====================");
        // 가격조건: 제품 가격이 50000원 이상일때, 5% 할인 , 60000원 이상일 때 7% 할인
        // 나이조건:나이가 7세이하이거나 70세 이상이면 10% 할인, 10대면 5%할인

        int itemPrice = 60000;
        int customerAge = 30;
        int discount = 0;

        // 범위 조건문 작성 시엔 조건문 순서 배치를 유의
        // ex) itemPrice >= 50000 조건이 더 앞에 있었다면, itemPrice >= 60000에 도달하지 못했을 것

        // 가격조건
        if (itemPrice >= 60000) {
            discount += itemPrice * 0.07;
        } else if (itemPrice >= 50000) {
            discount += itemPrice * 0.05;
        }

        // 나이조건
        if (customerAge >= 70 || customerAge <= 7) {
            discount += itemPrice * 0.10;
        } else if (customerAge >= 10 && customerAge < 20) {
            discount += itemPrice * 0.05;
        }

        System.out.println("결제하실 금액은 " + (itemPrice - discount));
    }

}
