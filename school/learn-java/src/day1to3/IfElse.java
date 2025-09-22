package day1to3;

public class IfElse {

    public static void main(String[] args) {


        System.out.println("[if-else] =================================================================");
         //1. 합격/불합격 판단
        int score1 = 85;

        if (score1 >= 60) {
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }

        // 2. 학점 계산
        int grade = 87;

        if (grade >= 90) {
            System.out.println("A");
        } else if (grade >= 80){
            System.out.println("B");
        } else if (grade >= 70) {
            System.out.println("C");
        } else {
            System.out.println("F");
        }



         //2. 중첩 조건문
        int score2 = 85;
        int attendance = 70;

        if (score2 >= 60) {

            if (attendance >= 75) {
                System.out.println("최종 합격");
            } else {
                System.out.println("출석 미달로 불합격");
            }

        } else {
            System.out.println("성적 미달로 불합격");
        }


        System.out.println("[switch] =================================================================");
         //1. 요일별 일정
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("월요일 : 회의");
                break;
            case 2:
                System.out.println("화요일 : 업무");
                break;
            case 3:
                System.out.println("수요일 : 휴식");
                break;
            default:
                System.out.println("다른 요일");
        }

        // 2. 계절 판별
        String month = "December";

        switch (month) {
            case "1월":
            case "2월":
            case "3월":
                System.out.println("겨울");
                break;
            case "4월":
            case "5월":
            case "6월":
                System.out.println("봄");
                break;
        }

        System.out.println("[if-else -> 삼항 연산자] =================================================================");
        int score3 = 85;

        if (score3 >= 60) {
            System.out.println("합격!");
        } else {
            System.out.println("불합격.");
        }

        String result = score3 >= 60 ? "합격" : "불합격";
        System.out.println("삼항 연산자 : " + result);

    }
}
