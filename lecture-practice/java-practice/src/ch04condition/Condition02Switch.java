package ch04condition;

public class Condition02Switch {
    public static void main(String[] args) {

        /*
        회원 등급에 따른 할인률
        Iron - 0%
        Bronze - 0%
        Silver  - 2%
        Gold - 3%
        Platinum - 5%
        * */

        String memberGrade = "Bronze";
        int discountRate = 0;

        System.out.println("==== if - else 문 ========================");
        if (memberGrade.equals("Iron") || memberGrade.equals("Bronze")) {
            discountRate = 0;
        } else if (memberGrade.equals("Silver")) {
            discountRate = 2;
        } else if (memberGrade.equals("Gold")) {
            discountRate = 3;
        } else if (memberGrade.equals("Platinum")) {
            discountRate = 4;
        } else {
            discountRate = -1;
        }
        System.out.println("할인률은 " + discountRate + "%입니다.");


        System.out.println("==== switch 문 ========================");
        switch (memberGrade) { // 연산식 or 변수

            // case 에는 단순한 값만 넣을 수 있음 (값이 동일한지만 확인하는 연산을 거침)
            // 정수(long 제외), enum , String, char, wrapper class(Integer, Character) 만이 가능
            case "Iron":
            case "Bronze":
                discountRate = 0;
                break;
            case "Silver":
                discountRate = 2;
                break;
            case "Gold":
                discountRate = 3;
                break;
            case "Platinum":
                discountRate = 5;
                break;
            default:
                discountRate = -1;
        }
        System.out.println("할인률은 " + discountRate + "%입니다.");


        System.out.println("==== 새로운 switch문 (java14+) ========================");
        // switch 가 값을 반환해줌
        discountRate = switch (memberGrade) {
            case "Iron", "Bronze" -> 0; // 여러 case에 쉼표로 묶기 가능
            case "Silver" -> 2;
            case "Gold" -> 3;
            case "Platinum" -> 5;

            default -> {
                System.out.println("없는 등급");
                yield -1;           // yield 로 블럭에서 값 반환
            }
        };
        System.out.println("할인률은 " + discountRate + "%입니다.");
    }


}



