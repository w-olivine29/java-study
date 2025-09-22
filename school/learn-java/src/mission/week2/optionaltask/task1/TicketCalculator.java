package mission.week2.optionaltask.task1;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


// 중복할인 x, 중복 시 가장 할인을 많이 받은 금액으로 책정

// 41기 유도경
public class TicketCalculator {

    public static void main(String[] args) {
        TicketCalculator ticketCalculator = new TicketCalculator(new Scanner(System.in));
        ticketCalculator.execute();
    }

    private final Scanner scanner;

    private static final int BASE_PRICE = 10_000;

    // 할인 금액
    private static final int GENERAL_DISCOUNT_PRICE = 2000; // 최종 8000원 지불
    private static final int SPECIAL_DISCOUNT_PRICE = 6000; // 최종 4000원 지불


    private int age;
    private LocalTime enteredTime;
    private boolean isNationalMerit;
    private boolean hasWelfareCard;


    public TicketCalculator(Scanner scanner) {
        this.scanner = scanner;
    }


    public void execute() {

        try (scanner) {
            System.out.println("입장권 계산");
            setAge();
            setEnteredTime();
            setIsNationalMerit();
            setHasWelfareCard();

            System.out.println("입장료: " + (BASE_PRICE - getDiscountAmount()));
        }
    }


    // 나이 3세미만 - 특별할인 - 일반할인 순 검사 (할인 금액이 큰 순으로)
    // 조건에 만족 시 바로 반환 (중복할인이 되지 않기 때문)
    private int getDiscountAmount() {
        if (isFree(age)) return BASE_PRICE;

        if (hasSpecialDiscount()) return SPECIAL_DISCOUNT_PRICE;

        if (hasGeneralDiscount()) return GENERAL_DISCOUNT_PRICE;

        return 0; // 할인 x
    }

    private boolean isFree(int age) {
        return age < 3;
    }


    private boolean hasSpecialDiscount() {
        return (age < 13 || enteredTime.isAfter(LocalTime.of(16, 59))); //17시 0분 부터 적용
    }

    private boolean hasGeneralDiscount() {
        return isNationalMerit || hasWelfareCard;
    }

    private void setAge() {
        while (true) {
            System.out.print("나이를 입력해 주세요.(숫자): ");
            try {
                age = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("다시 입력해주세요.");
            } finally {
                scanner.nextLine(); // 소모되지 못한 개행문자 비우기
            }
        }
    }

    private void setEnteredTime() {

        String input;
        String inputPattern = "^([01]\\d|2[0-3]):([0-5]\\d)$";
        while (true) {

            System.out.print("입장시간을 입력해 주세요.[시간:분]:  ");
            try {
                input = scanner.nextLine();
                if (!input.matches(inputPattern)) {
                    System.out.println("올바른 시간형식으로 입력해주세요. (시간:분)");
                    continue;
                }

                int[] time = Arrays.stream(input.split(":")).mapToInt(Integer::parseInt).toArray();
                enteredTime = LocalTime.of(time[0], time[1]);
                return;

            } catch (Exception e) {
                System.out.println("다시 입력해주세요.");
                scanner.nextLine();
            }
        }
    }

    private void setIsNationalMerit() {
        isNationalMerit = inputYesOrNo("국가유공자");
    }

    private void setHasWelfareCard() {
        hasWelfareCard = inputYesOrNo("복지카드");
    }


    private boolean inputYesOrNo(String category) {

        String input = "";
        while (!("y".equals(input) || "n".equals(input))) {
            System.out.print(category + " 여부를 입력해 주세요.(y/n): ");
            input = scanner.nextLine().toLowerCase();
        }
        return "y".equals(input);
    }
}
